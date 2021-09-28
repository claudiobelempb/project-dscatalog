package br.com.surb.dscatalog.repositories;

import br.com.surb.dscatalog.Factory;
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
  private long countTotalProdutc;

  @BeforeEach
  void setUp() throws Exception {
    existingId = 1L;
    nonExistingId = 1000L;
    countTotalProdutc = 25L;
  }

  @Test
  public void saveShouldPersistWhithAutoincrementWhenIdsNull() {
    Product product = Factory.createProduct();
    product.setId(null);
    product = productRepository.save(product);
    Assertions.assertNotNull(product.getId());
    Assertions.assertEquals(countTotalProdutc + 1, product.getId());
  }

  @Test
  public void saveShouldNotEmptyWhenIdExists(){
    productRepository.findById(existingId);
    Optional<Product> product = productRepository.findById(nonExistingId);
    Assertions.assertFalse(product.isPresent());
  }

  @Test
  public void saveShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist(){
    productRepository.findById(existingId);
    Optional<Product> product = productRepository.findById(existingId);
    Assertions.assertFalse(product.isEmpty());
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
