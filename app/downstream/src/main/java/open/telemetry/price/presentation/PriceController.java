package open.telemetry.price.presentation;

import open.telemetry.price.domain.Price;
import open.telemetry.price.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//(value = "price")
@RequestMapping("price")
public class PriceController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    PriceService priceService;

    PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(path = "{id}")
    Price price(@PathVariable("id") long productId) {
        logger.info("Getting Price details for Product Id {}", productId);
        return priceService.priceOf(productId);
    }

}
