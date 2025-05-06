
package it.finalround.config;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import jakarta.persistence.EntityNotFoundException;
import java.util.Map;
@ControllerAdvice
public class RestExceptionHandler{
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public Map<String,String> badRequest(Exception ex){ return Map.of("error", ex.getMessage());}

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public Map<String,String> notFound(Exception ex){ return Map.of("error", ex.getMessage());}

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public Map<String,String> generic(Exception ex){ return Map.of("error", ex.getMessage());}
}
