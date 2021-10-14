package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {
  private static final long serialVersionUID = -114325461620419754L;

  private Long id;

  @NotBlank(message = "Campo nome obrigratório")
  @Size(min = 5, message = "Campo nome deve ter entre 5 e 30 caracter")
  private String firstName;

  @NotBlank(message = "Campo sobrenome obrigratório")
  @Size(min = 5, message = "Campo sobrenome deve ter entre 5 e 30 caracter")
  private String lastName;

  @Email(message = "Campo Email ou senha iválido")
  private String email;

  private Instant createdAt;
  private Instant updatedAt;

  private Set<RoleDTO> roles = new HashSet<>();

  public UserDTO() {
  }

  public UserDTO(Long id, String firstName, String lastName, String email, Instant createdAt,
                 Instant updatedAt) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UserDTO(User user) {
    id = user.getId();
    firstName = user.getFirstName();
    lastName = user.getLastName();
    email = user.getEmail();
    user.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    createdAt = user.getCreatedAt();
    updatedAt = user.getUpdatedAt();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Set<RoleDTO> getRoles() {
    return roles;
  }
}
