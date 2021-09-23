package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public Page<CategoryDTO> index(Pageable pageable) {
    Page<Category> categories = categoryRepository.findAll(pageable);
    return categories.map(category -> new CategoryDTO((category)));
  }

  @Transactional(readOnly = true)
  public CategoryDTO show(Long id) {
    Optional<Category> obj = categoryRepository.findById(id);
    Category category = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new CategoryDTO((category));
  }

  @Transactional
  public CategoryDTO create(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setName(categoryDTO.getName());
    category = categoryRepository.save(category);
    return new CategoryDTO(category);
  }

  @Transactional
  public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
    try {
      Category category = categoryRepository.getOne(id);
      category.setName(categoryDTO.getName());
      category = categoryRepository.save(category);
      return new CategoryDTO(category);
    } catch (EntityNotFoundException e){
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }

  public void delete(Long id) {
    try {
      categoryRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Id not found" + id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }
}
