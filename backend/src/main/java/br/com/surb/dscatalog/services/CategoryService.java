package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new CategoryDTO((entity));
  }

  @Transactional
  public CategoryDTO create(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setName(categoryDTO.getName());
    category = repository.save(category);
    return new CategoryDTO(category);
  }

  @Transactional
  public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
    try {
      Category category = repository.getOne(id);
      category.setName(categoryDTO.getName());
      category = repository.save(category);
      return new CategoryDTO(category);
    } catch (EntityNotFoundException e){
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }
}
