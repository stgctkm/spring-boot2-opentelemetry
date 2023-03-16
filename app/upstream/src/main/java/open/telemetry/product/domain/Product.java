package open.telemetry.product.domain;

public record Product(
        long id,
        String name,
        Price price
) {
}
