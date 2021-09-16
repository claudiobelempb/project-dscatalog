package br.com.surb.dscatalog.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String cpf;
  private Double income;
  private Integer children;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant birthDate;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public Client() {
  }

  public Client(Long id, String name, String cpf, Double income, Instant birthDate, Integer children,
                Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public Instant getBirthDate() { return birthDate; }

  public void setBirthDate(Instant birthDate) {
    this.birthDate = birthDate;
  }

  public Integer getChildren() {
    return children;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }

  public Instant getCreatedAt() { return createdAt; }

  public Instant getUpdatedAt() { return updatedAt; }

  @PrePersist
  public void preCreate() {
    createdAt = Instant.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Client client = (Client) o;
    return id.equals(client.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
