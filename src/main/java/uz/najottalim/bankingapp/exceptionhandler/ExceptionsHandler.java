package uz.najottalim.bankingapp.exceptionhandler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.najottalim.bankingapp.dto.errordto.ErrorDto;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDto noResourceHandler(NoResourceFoundException exception){
        return ErrorDto.builder().error(exception.getMessage()).build();
    }


    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto dataAccessExceptionHandler(DataAccessException ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto unknownExceptionsHandler(Throwable ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }
}
