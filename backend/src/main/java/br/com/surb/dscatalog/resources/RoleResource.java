package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.RoleDTO;
import br.com.surb.dscatalog.entities.Role;
import br.com.surb.dscatalog.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/roles")
public class RoleResource {

  @Autowired
  private RoleService roleService;

  @GetMapping
  public ResponseEntity<Page<RoleDTO>> index(Pageable pageable){
    Page<RoleDTO> roles = roleService.index(pageable);
    return ResponseEntity.ok().body(roles);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<RoleDTO> show(@PathVariable Long id) {
    RoleDTO roleDTO = roleService.show(id);
    return ResponseEntity.ok().body(roleDTO);
  }

  @PostMapping
  public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO){
    roleDTO = roleService.create(roleDTO);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequestUri().path("/id")
      .buildAndExpand(roleDTO.getId())
      .toUri();
    return ResponseEntity.ok().body(roleDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<RoleDTO> update(@Valid @PathVariable Long id, @RequestBody RoleDTO roleDTO) {
    roleDTO = roleService.update(id, roleDTO);
    return ResponseEntity.ok().body(roleDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    roleService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
