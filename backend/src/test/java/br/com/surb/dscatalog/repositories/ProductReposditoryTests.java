package br.com.surb.dscatalog.repositories;

import br.com.surb.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;


import java.util.Optional;

@DataJpaTest
public class ProductReposditoryTests {

  @Autowired
  private ProductRepository productRepository;

  private long existingId;
  private long nonExistingId;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
  }

  @Test
  public void deleteShouldDeleteObjetcWhenIdExists() {
    productRepository.deleteById(existingId);
    Optional<Product> product = productRepository.findById(existingId);
    Assertions.assertFalse(product.isPresent());
  }

  @Test
  public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
    Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
      productRepository.deleteById(nonExistingId);
    });
  }

}
