package br.com.surb.dscatalog.services;

import br.com.surb.dscatalog.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
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

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    Mockito.doNothing().when(productRepository).deleteById(existingId);
    Mockito.doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(nonExistingId);
  }

  @Test
  public void deleteShouldDoNothingWhenIdExists(){
    Assertions.assertDoesNotThrow(() -> {
      productService.delete(existingId);
    });

    Mockito.verify(productRepository, Mockito.times(1)).deleteById(existingId);
  }
  

}
