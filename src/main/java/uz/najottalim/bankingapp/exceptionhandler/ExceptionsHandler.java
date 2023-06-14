package uz.najottalim.bankingapp.exceptionhandler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto throwableHandler(Exception ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }
    
}
