package uz.najottalim.bankingapp.exceptionhandler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.najottalim.bankingapp.dto.errordto.ErrorDto;
import uz.najottalim.bankingapp.exception.LimitAccessException;
import uz.najottalim.bankingapp.exception.NoResourceFoundException;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto noResourceHandler(NoResourceFoundException ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto dataAccessExceptionHandler(DataAccessException ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }

    @ExceptionHandler(LimitAccessException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorDto noAccessHandler(LimitAccessException ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto throwableHandler(Throwable ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }
    
}
