package open.telemetry.product.infrastructure;

import open.telemetry.product.domain.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PriceTransfer {

    RestTemplate restTemplate;

    @Value("${priceClient.baseUrl}")
    private String baseUrl;

    Logger logger = LoggerFactory.getLogger(PriceTransfer.class);

    PriceTransfer(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Price getPrice(long productId){
        logger.info("Fetching Price Details With Product Id {}", productId);
        String url = String.format("%s/price/%d", baseUrl, productId);
        ResponseEntity<Price> price = restTemplate.getForEntity(url, Price.class);
        return price.getBody();
    }
}
