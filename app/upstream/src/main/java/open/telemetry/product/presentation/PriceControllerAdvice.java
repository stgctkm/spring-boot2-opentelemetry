package open.telemetry.price.presentation;

import open.telemetry.price.infrastructure.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PriceControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
