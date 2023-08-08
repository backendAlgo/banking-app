package uz.najottalim.bankingapp.exeption.ExeptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.najottalim.bankingapp.dto.ErrorDto;
import uz.najottalim.bankingapp.exeption.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto noResourceFoundExceptionHandler(NoResourceFoundException exception){
        return ErrorDto.builder().errors(exception.getMessage()).build();
    }


}
