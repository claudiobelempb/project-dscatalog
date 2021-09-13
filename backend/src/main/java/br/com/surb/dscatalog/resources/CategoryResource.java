package br.com.surb.dscatalog.resources;

import br.com.surb.dscatalog.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  @GetMapping
  public ResponseEntity<List<Category>> index() {
    List<Category> list = new ArrayList<>();
    list.add(new Category(1L, "Book"));
    list.add(new Category(2L, "Eletronics"));
    return ResponseEntity.ok().body(list);
  }
}
