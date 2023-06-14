package uz.najottalim.bankingapp.ExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.najottalim.bankingapp.exception.NoResourceNotFoundException;

import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = NoResourceNotFoundException.class)
    @ResponseStatus
    public ResponseEntity<Map<String,String>> handleNoReNOFound(NoResourceNotFoundException exception){
        return ResponseEntity.ok(Map.of("errors", exception.getMessage()));
    }
}
