package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.UserCreateDTO;
import br.com.surb.dscatalog.dto.UserDTO;
import br.com.surb.dscatalog.dto.UserUpdateDTO;
import br.com.surb.dscatalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<Page<UserDTO>> index(Pageable pageable){
    Page<UserDTO> users = userService.index(pageable);
    return ResponseEntity.ok().body(users);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> show(@PathVariable Long id){
    UserDTO user = userService.show(id);
    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<UserDTO> create(@Valid @RequestBody UserCreateDTO userCreateDTO){
    UserDTO userDTO = userService.create(userCreateDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
      .path("/{id}")
      .buildAndExpand(userDTO.getId())
      .toUri();
    return ResponseEntity.created(uri).body(userDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserDTO> update(@Valid @PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO){
    UserDTO userDTO = userService.update(id, userUpdateDTO);
    return ResponseEntity.ok().body(userDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> detele(@PathVariable Long id){
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
