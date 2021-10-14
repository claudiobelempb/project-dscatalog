package br.com.surb.dscatalog.services.validation;

import br.com.surb.dscatalog.dto.UserCreateDTO;
import br.com.surb.dscatalog.entities.User;
import br.com.surb.dscatalog.repositories.UserRepository;
import br.com.surb.dscatalog.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserCreateValidator implements ConstraintValidator<UserCreateValid, UserCreateDTO> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void initialize(UserCreateValid ann) {
  }

  @Override
  public boolean isValid(UserCreateDTO userCreateDTO, ConstraintValidatorContext constraintValidatorContext) {

    List<FieldMessage> fieldMessageList = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User user = userRepository.findByEmail(userCreateDTO.getEmail());
    if(user != null){
      fieldMessageList.add(new FieldMessage("email", "Email já existe"));
    }

    for (FieldMessage fieldMessage : fieldMessageList) {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(fieldMessage.getMessage()).addPropertyNode(fieldMessage.getFieldName())
        .addConstraintViolation();
    }
    return fieldMessageList.isEmpty();
  }
}
