package open.telemetry.product.service;

import open.telemetry.product.domain.Product;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product productOf(long productId) {
        return productRepository.productOf(productId);
    }
}
