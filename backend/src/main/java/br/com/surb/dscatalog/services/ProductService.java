package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.dto.CategoryDTO;
import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.entities.Product;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import br.com.surb.dscatalog.repositories.ProductRepository;
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
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public Page<ProductDTO> index(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);
    return products.map((product -> new ProductDTO(product, product.getCategories())));
  }

  @Transactional(readOnly = true)
  public ProductDTO show(Long id) {
    Optional<Product> obj = productRepository.findById(id);
    Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new ProductDTO(product, product.getCategories());
  }

  @Transactional
  public ProductDTO create(ProductDTO productDTO) {
    Product product = new Product();
    copyDtoToEntity(productDTO, product);
    product = productRepository.save(product);
    return new ProductDTO(product);
  }

  @Transactional
  public ProductDTO update(Long id, ProductDTO productDTO) {
    try {
      Product product = productRepository.getOne(id);
      copyDtoToEntity(productDTO, product);
      product = productRepository.save(product);
      return new ProductDTO(product);
    } catch (EntityNotFoundException e){
      throw new ResourceNotFoundException("Id not found" + id);
    }
  }

  public void delete(Long id) {
    try {
      productRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e){
      throw new ResourceNotFoundException("Id not found" + id);
    } catch (DataIntegrityViolationException e) {
      throw new DataBaseException("Integrity violation");
    }
  }

  private void copyDtoToEntity(ProductDTO productDTO, Product product){
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setImgUrl(productDTO.getImgUrl());
    product.setCreatedAt(productDTO.getCreatedAt());

    product.getCategories().clear();
    for (CategoryDTO categoryDTO : productDTO.getCategories()) {
      Category category = categoryRepository.getOne(categoryDTO.getId());
      product.getCategories().add(category);
    }
}

}
