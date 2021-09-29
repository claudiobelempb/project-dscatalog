package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.repositories.ProductRepository;
import br.com.surb.dscatalog.services.exceptions.DataBaseException;
import br.com.surb.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

  @InjectMocks
  private ProductService productService;

  @Mock
  private ProductRepository productRepository;

  private long existingId;
  private long nonExistingId;
  private long dependentId;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    nonExistingId = 4L;
    Mockito.doNothing().when(productRepository).deleteById(existingId);
    Mockito.doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(nonExistingId);
    Mockito.doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);
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
