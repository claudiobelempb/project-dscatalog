package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*
Parâmetros de paginação

@RequestParam(value = "page", defaultValue = "0") Integer page,
@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
@RequestParam(value = "direction", defaultValue = "DESC") String direction)
*/


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<Page<CategoryDTO>> index(Pageable pageable) {
    Page<CategoryDTO> cayegories = service.index(pageable);
    return ResponseEntity.ok().body(cayegories);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> show(@PathVariable Long id){
    CategoryDTO category = service.show(id);
    return ResponseEntity.ok().body(category);
  }

  @PostMapping
  public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO){
    categoryDTO = service.create(categoryDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoryDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(categoryDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> update(@Valid @PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
    categoryDTO = service.update(id, categoryDTO);
    return ResponseEntity.ok().body(categoryDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> detele(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
