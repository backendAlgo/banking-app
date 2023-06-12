package uz.najottalim.bankingapp.exceptions;

import lombok.Data;

@Data
public class NoResourceFoundException extends RuntimeException {
    private static final String MESSAGE = "Requested resource not found";

    public NoResourceFoundException(String message) {
        super(message);
    }
    public NoResourceFoundException() {
    }
}
