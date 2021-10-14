package br.com.surb.dscatalog.services.validation;

import br.com.surb.dscatalog.dto.UserCreateDTO;
import br.com.surb.dscatalog.dto.UserUpdateDTO;
import br.com.surb.dscatalog.entities.User;
import br.com.surb.dscatalog.repositories.UserRepository;
import br.com.surb.dscatalog.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

  @Autowired
  private HttpServletRequest httpServletRequest;

  @Autowired
  private UserRepository userRepository;

  @Override
  public void initialize(UserUpdateValid ann) {
  }

  @Override
  public boolean isValid(UserUpdateDTO userUpdateDTO, ConstraintValidatorContext constraintValidatorContext) {

    var uriVars = (Map<String, String>)
      httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    long userId = Long.parseLong(uriVars.get("id"));

    List<FieldMessage> fieldMessageList = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User user = userRepository.findByEmail(userUpdateDTO.getEmail());
    if(user != null && userId != user.getId()){
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
