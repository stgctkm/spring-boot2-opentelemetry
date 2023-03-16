package open.telemetry.price.infrastructure;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String priceNotFound) {
        super(priceNotFound);
    }
}
