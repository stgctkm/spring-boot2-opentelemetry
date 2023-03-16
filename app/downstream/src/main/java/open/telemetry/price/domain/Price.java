package open.telemetry.price.domain;

public record Price(
        long productId,
        double price,
        double discount
) {
}
