package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Category;
import br.com.surb.dscatalog.entities.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO implements Serializable {
  private static final long serialVersionUID = 694675675061996281L;

  private Long id;

  @NotBlank(message = "Campo nome é obrigratório")
  @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracter")
  private String name;

  @NotBlank(message = "Campo descrição é obrigratório")
  @Size(min = 5, max = 220, message = "Deve ter entre 5 e 220 caracter")
  private String description;

  @Positive(message = "Preço deve ser um valor positivo")
  private Double price;

  @NotBlank(message = "Campo imgURL é obrigratório")
  @Size(min = 5, max = 60, message = "Deve ter entre 5 e 220 caracter")
  private String imgUrl;

  @PastOrPresent(message = "A data do produto não pode ser futura")
  private Instant createdAt;

  @PastOrPresent(message = "A data do produto não pode ser futura")
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
