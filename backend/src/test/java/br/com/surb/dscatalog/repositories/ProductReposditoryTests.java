package br.com.surb.dscatalog.repositories;

import br.com.surb.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

@DataJpaTest
public class ProductReposditoryTests {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void deleteShouldDeleteObjetcWhenIdExists() {

    long existingId = 1L;

    productRepository.deleteById(existingId);

    Optional<Product> product = productRepository.findById(existingId);

    Assertions.assertFalse(product.isPresent());

  }

}
