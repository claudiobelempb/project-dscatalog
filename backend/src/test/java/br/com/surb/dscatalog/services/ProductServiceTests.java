package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.Factory;
import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.entities.Product;
import br.com.surb.dscatalog.repositories.CategoryRepository;
import br.com.surb.dscatalog.repositories.ProductRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

  @InjectMocks
  private ProductService productService;

  @Mock
  private ProductRepository productRepository;

  @Mock
  private CategoryRepository categoryRepository;

  private long existingId;
  private long nonExistingId;
  private long dependentId;
  private PageImpl<Product> page;
  private Product product;
  private ProductDTO productDTO;
  private Category category;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 2L;
    dependentId = 3L;
    product = Factory.createProduct();
    productDTO = Factory.createProductDTO();
    category = Factory.createCategory();
    page = new PageImpl<>(List.of(product));

    Mockito.when(productRepository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);
    Mockito.when(productRepository.save(ArgumentMatchers.any())).thenReturn(product);

    Mockito.when(productRepository.findById(existingId)).thenReturn(Optional.of(product));
    Mockito.when(productRepository.findById(nonExistingId)).thenReturn(Optional.empty());

    Mockito.when(productRepository.getOne(existingId)).thenReturn(product);
    Mockito.when(productRepository.getOne(nonExistingId)).thenThrow(ResourceNotFoundException.class);

    Mockito.when(categoryRepository.getOne(existingId)).thenReturn(category);
    Mockito.when(categoryRepository.getOne(nonExistingId)).thenThrow(ResourceNotFoundException.class);

    Mockito.doNothing().when(productRepository).deleteById(existingId);
    Mockito.doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(nonExistingId);
    Mockito.doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);
  }

  @Test
  public void indexShouldReturnPage() {
    Pageable pageable = PageRequest.of(0, 10);
    Page<ProductDTO> productDTOS = productService.index(pageable);
    Assertions.assertNotNull(dependentId);
    Mockito.verify(productRepository, Mockito.times(1)).findAll(pageable);
  }

  @Test
  public void showShouldReturnProductDTOWhenIdExists() {
    ProductDTO productDTO = productService.show(existingId);
    Assertions.assertNotNull(productDTO);
    Mockito.verify(productRepository, Mockito.times(1)).findById(existingId);
  }

  @Test
  public void showShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){
    Assertions.assertThrows(ResourceNotFoundException.class, () -> {
      productService.show(nonExistingId);
    });

    Mockito.verify(productRepository, Mockito.times(1)).findById(nonExistingId);
  }

  @Test
  public void updateShouldReturnProductDTOWhenIdExists() {
    ProductDTO result = productService.update(existingId, productDTO);
    Assertions.assertNotNull(result);
    
  }

  @Test
  public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){
    Assertions.assertThrows(ResourceNotFoundException.class, () -> {
      productService.update(nonExistingId, productDTO);
    });
  }

  @Test
  public void deleteShouldThrowDataBaseExceptionWhenIdDoesNotExists(){
    Assertions.assertThrows(DataBaseException.class, () -> {
      productService.delete(dependentId);
    });

    Mockito.verify(productRepository, Mockito.times(1)).deleteById(dependentId);
  }

  @Test
  public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){
    Assertions.assertThrows(ResourceNotFoundException.class, () -> {
      productService.delete(nonExistingId);
    });

    Mockito.verify(productRepository, Mockito.times(1)).deleteById(nonExistingId);
  }

  @Test
  public void deleteShouldDoNothingWhenIdExists(){
    Assertions.assertDoesNotThrow(() -> {
      productService.delete(existingId);
    });

    Mockito.verify(productRepository, Mockito.times(1)).deleteById(existingId);
  }


}
