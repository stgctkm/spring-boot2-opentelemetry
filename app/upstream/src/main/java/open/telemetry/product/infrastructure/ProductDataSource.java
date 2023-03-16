package open.telemetry.product.infrastructure;

//import jakarta.annotation.PostConstruct;
import open.telemetry.price.infrastructure.ProductNotFoundException;
import open.telemetry.product.domain.Price;
import open.telemetry.product.domain.Product;
import open.telemetry.product.service.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDataSource implements ProductRepository {

    PriceTransfer priceTransfer;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Map<Long, Product> productMap = new HashMap<>();

    ProductDataSource(PriceTransfer priceTransfer) {
        this.priceTransfer = priceTransfer;
    }

    @PostConstruct
    private void setupRepo() {
        Product product1 = getProduct(100001, "apple");
        productMap.put(100001L, product1);

        Product product2 = getProduct(100002, "pears");
        productMap.put(100002L, product2);

        Product product3 = getProduct(100003, "banana");
        productMap.put(100003L, product3);

        Product product4 = getProduct(100004, "mango");
        productMap.put(100004L, product4);

        Product product5 = getProduct(100005, "test");
        productMap.put(100005L, product5);
    }

    private static Product getProduct(int id, String name) {
        return new Product(id, name, null);
    }

    @Override
    public Product productOf(long productId) {
        logger.info("Getting Product from Product Repo With Product Id {}", productId);

        if(!productMap.containsKey(productId)){
            logger.error("Product Not Found for Product Id {}", productId);
            throw new ProductNotFoundException("Product Not Found");
        }

        Product product = productMap.get(productId);
        Price price = priceTransfer.getPrice(productId);
        return new Product(product.id(), product.name(), price);
    }

}
