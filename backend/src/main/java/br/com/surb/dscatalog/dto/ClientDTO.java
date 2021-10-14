package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Client;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

public class ClientDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotBlank(message = "Campo nome obrigratório")
  @Size(min = 5, max = 30, message = "Campo sobrenome deve ter entre 5 e 30 caracter")
  private String name;

  private String cpf;
  private Double income;
  private Integer children;

  private Instant birthDate;
  private Instant createdAt;
  private Instant updatedAt;

  public ClientDTO(){}

  public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children,
                   Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public ClientDTO(Client client){
    this.id = client.getId();
    this.name = client.getName();
    this.cpf = client.getCpf();
    this.income = client.getIncome();
    this.birthDate = client.getBirthDate();
    this.children = client.getChildren();
    this.createdAt = client.getCreatedAt();
    this.updatedAt = client.getUpdatedAt();
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

  public Instant getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Instant birthDate) {
    this.birthDate = birthDate;
  }

  public Integer getChildren() {
    return children;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

}
