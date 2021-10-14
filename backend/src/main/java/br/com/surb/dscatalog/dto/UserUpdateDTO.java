package br.com.surb.dscatalog.dto;

import br.com.surb.dscatalog.services.validation.UserCreateValid;
import br.com.surb.dscatalog.services.validation.UserUpdateValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO {
  private static final long serialVersionUID = -114325461620419754L;
}
