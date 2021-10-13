package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<Page<ProductDTO>> index(Pageable pageable){
    /*
    PARAMETROS:   pages, size, sort
    PageRequest pageRequest = PageRequest.of(pageable.pages, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
    */
    Page<ProductDTO> products = productService.index(pageable);
    return ResponseEntity.ok().body(products);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> show(@PathVariable Long id){
    ProductDTO category = productService.show(id);
    return ResponseEntity.ok().body(category);
  }

  @PostMapping
  public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO){
    productDTO = productService.create(productDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(productDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(productDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> update(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO){
    productDTO = productService.update(id, productDTO);
    return ResponseEntity.ok().body(productDTO);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> detele(@PathVariable Long id){
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
