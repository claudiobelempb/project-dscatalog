package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.services.validation.UserCreateValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@UserCreateValid
public class UserCreateDTO extends UserDTO {
  private static final long serialVersionUID = -114325461620419754L;

  @NotBlank(message = "Campo senha é obrigratório")
  @Size(min = 5, max = 30, message = "Campo sobrenome deve ter entre 5 e 30 caracter")
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
