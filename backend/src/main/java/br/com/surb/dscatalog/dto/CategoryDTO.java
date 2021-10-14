package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Category;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotBlank(message = "Campo nome é obrigatório")
  @Size(min = 5, max = 30, message = "Campo nome deve ter entre 5 e 30 caracter")
  private String name;

  @PastOrPresent(message = "Data inválida")
  private Instant createdAt;

  @PastOrPresent(message = "Data inválida")
  private Instant updatedAt;

  public CategoryDTO(){}

  public CategoryDTO(Long id, String name, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.createdAt = category.getCreatedAt();
    this.updatedAt = category.getUpdatedAt();
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

}
