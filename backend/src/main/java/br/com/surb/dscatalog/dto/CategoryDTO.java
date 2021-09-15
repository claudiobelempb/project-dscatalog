package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Category;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.Instant;

public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
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

  @PrePersist
  public void preCreate(){
    createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }
}
