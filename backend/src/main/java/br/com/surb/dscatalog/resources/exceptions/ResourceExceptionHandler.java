package br.com.surb.dscatalog.resources.exceptions;

import br.com.surb.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {
  private static final long serialVersionUID = 3954709874141773724L;

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<StandarError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
    StandarError err = new StandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setError("Resource not found");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
}
