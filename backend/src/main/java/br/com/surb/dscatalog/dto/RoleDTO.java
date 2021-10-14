package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.Role;
import br.com.surb.dscatalog.entities.User;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class RoleDTO implements Serializable {
  private static final long serialVersionUID = -3275160846147522149L;

  private Long id;

  @NotBlank(message = "Campo nome é obrigatório")
  @Size(min = 5, max = 30, message = "Campo autorização deve ter entre 5 e 30 caracter")
  private String authority;
  private Instant createdAt;
  private Instant updatedAt;

  public RoleDTO() {}

  public RoleDTO(Long id, String authority, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.authority = authority;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RoleDTO(Role role) {
    id = role.getId();
    authority = role.getAuthority();
    createdAt = role.getCreatedAt();
    updatedAt = role.getUpdatedAt();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
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

}
