package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  @Transactional(readOnly = true)
  public List<CategoryDTO> index() {
    List<Category> list = repository.findAll();
    return list.stream().map(x -> new CategoryDTO((x))).collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public CategoryDTO show(Long id) {
    Optional<Category> obj = repository.findById(id);
    Category entity = obj.get();
    return new CategoryDTO((entity));
  }

}
