package uz.najottalim.bankingapp.exception;

public class NoResourceNotFoundException extends RuntimeException {
    public NoResourceNotFoundException(String message) {
        super(message);
    }
}
