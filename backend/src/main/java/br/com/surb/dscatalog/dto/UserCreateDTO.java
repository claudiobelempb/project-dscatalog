package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.entities.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class UserCreateDTO extends UserDTO {
  private static final long serialVersionUID = -114325461620419754L;

  private String password;

  public UserCreateDTO() {
    super();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
