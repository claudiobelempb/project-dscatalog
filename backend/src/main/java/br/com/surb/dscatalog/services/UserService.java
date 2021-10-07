package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.RoleDTO;
import br.com.surb.dscatalog.dto.UserCreateDTO;
import br.com.surb.dscatalog.dto.UserDTO;
import br.com.surb.dscatalog.entities.Role;
import br.com.surb.dscatalog.entities.User;
import br.com.surb.dscatalog.repositories.RoleRepository;
import br.com.surb.dscatalog.repositories.UserRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Transactional(readOnly = true)
  public Page<UserDTO> index(Pageable pageable) {
    Page<User> users = userRepository.findAll(pageable);
    return users.map((user -> new UserDTO(user)));
  }

  @Transactional(readOnly = true)
  public UserDTO show(Long id) {
    Optional<User> obj = userRepository.findById(id);
    User user = obj.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
    return new UserDTO(user);
  }

  @Transactional
  public UserDTO create(UserCreateDTO userCreateDTO){
    User user = new User();
    copyUserCreateDto(userCreateDTO, user);
    user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
    user = userRepository.save(user);
    return new UserDTO(user);
  }

  @Transactional
  public UserDTO update(Long id, UserDTO userDTO) {
    try {
      User user = userRepository.getOne(id);
      copyUserCreateDto(userDTO, user);
      user = userRepository.save(user);
      return new UserDTO(user);
    } catch (EntityNotFoundException e){
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }

  public void delete(Long id) {
    try {
      userRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Id not found" + id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }

  private void copyUserCreateDto(UserDTO userDTO, User user) {
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setEmail(userDTO.getEmail());

    user.getRoles().clear();
    for (RoleDTO roleDTO : userDTO.getRoles()) {
      Role role = roleRepository.getOne(roleDTO.getId());
      user.getRoles().add(role);
    }
  }

}
