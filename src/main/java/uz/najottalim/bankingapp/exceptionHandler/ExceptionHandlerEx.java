package uz.najottalim.bankingapp.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.najottalim.bankingapp.Dto.ErrorDTO;
import uz.najottalim.bankingapp.exception.NoRecurseFoundException;

@RestControllerAdvice
public class ExceptionHandlerEx {
    @ExceptionHandler(NoRecurseFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO noFoundRecurseException(NoRecurseFoundException ex){
        return ErrorDTO.builder().errors("Not Found Exception").build();
    }
}
