package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.RoleDTO;
import br.com.surb.dscatalog.entities.Role;
import br.com.surb.dscatalog.repositories.RoleRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Transactional(readOnly = true)
  public Page<RoleDTO> index(Pageable pageable) {
    Page<Role> roles = roleRepository.findAll(pageable);
    return roles.map(role -> new RoleDTO((role)));
  }

  @Transactional(readOnly = true)
  public RoleDTO show(Long id) {
    Optional<Role> optionalRole = roleRepository.findById(id);
    Role role = optionalRole.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    return new RoleDTO(role);
  }

  @Transactional
  public RoleDTO create(RoleDTO roleDTO){
    Role role = new Role();
    role.setAuthority(roleDTO.getAuthority());
    role = roleRepository.save(role);
    return new RoleDTO(role);
  }

  @Transactional
  public RoleDTO update(Long id, RoleDTO roleDTO) {
    try {
      Role role = roleRepository.getOne(id);
      role.setAuthority(roleDTO.getAuthority());
      role = roleRepository.save(role);
      return new RoleDTO(role);
    }catch (EntityNotFoundException e){
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }

  @Transactional
  public void delete(Long id) {
    try {
      roleRepository.deleteById(id);
    }catch (EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Id not found " + id);
    }catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }

}
