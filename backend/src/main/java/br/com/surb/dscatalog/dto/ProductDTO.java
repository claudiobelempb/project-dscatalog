package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.entities.Product;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO implements Serializable {
  private static final long serialVersionUID = 694675675061996281L;

  private Long id;
  private String name;
  private String description;
  private Double price;
  private String imgUrl;
  private Instant createdAt;
  private Instant updatedAt;

  private List<CategoryDTO> categories = new ArrayList<>();

  public ProductDTO(){}

  public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant createdAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
    this.createdAt = createdAt;
  }

  public ProductDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.imgUrl = product.getImgUrl();
    this.createdAt = product.getCreatedAt();
  }

  public ProductDTO(Product product, Set<Category> categories) {
    this(product);
    categories.forEach(category -> this.categories.add(new CategoryDTO(category)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<CategoryDTO> getCategories() {
    return categories;
  }

}
