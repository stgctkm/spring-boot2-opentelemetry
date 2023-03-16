package open.telemetry.product.service;

import open.telemetry.product.domain.Product;

public interface ProductRepository {
    Product productOf(long productId);
}
