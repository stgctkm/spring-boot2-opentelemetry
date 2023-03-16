package open.telemetry.price.service;

import open.telemetry.price.domain.Price;

public interface PriceRepository {
    Price priceOf(long productId);
}
