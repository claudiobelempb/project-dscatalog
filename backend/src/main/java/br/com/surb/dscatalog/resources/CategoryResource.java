package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> index() {
    List<CategoryDTO> cayegories = service.index();
    return ResponseEntity.ok().body(cayegories);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> show(@PathVariable Long id){
    CategoryDTO category = service.show(id);
    return ResponseEntity.ok().body(category);
  }

  @PostMapping
  public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO){
    categoryDTO = service.create(categoryDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoryDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(categoryDTO);
  }
}
