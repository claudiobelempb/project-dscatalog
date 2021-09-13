package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public List<Category> findAll() {
    return repository.findAll();
  }

}
