package br.com.surb.dscatalog;

import br.com.surb.dscatalog.dto.ProductDTO;
import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

  public static Product createProduct() {
    Product product = new Product(1L, "Phone", "Good Phone", 90.5,
      "https://img/1-big.jpg", Instant.parse("2021-09-27T23:51:17.658125Z"));
    product.getCategories().add(new Category(2L, "Eletronics"));
    return product;
  }

  public static ProductDTO createProductDTO() {
    Product product = createProduct();
    return new ProductDTO(product, product.getCategories());
  }
}
