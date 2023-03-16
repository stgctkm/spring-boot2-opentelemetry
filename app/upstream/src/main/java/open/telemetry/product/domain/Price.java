package open.telemetry.product.domain;

public record Price(
        long productId,
        double price,
        double discount
) {
}
