package open.telemetry.product.presentation;

import open.telemetry.product.domain.Product;
import open.telemetry.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "{id}")
    Product product(@PathVariable("id") long productId) {
        logger.info("Getting Product and Price Details with Product Id {}", productId);
        return productService.productOf(productId);
    }

}
