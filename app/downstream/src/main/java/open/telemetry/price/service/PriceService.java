package open.telemetry.price.service;

import open.telemetry.price.domain.Price;
import org.springframework.stereotype.Service;


@Service
public class PriceService {
    PriceRepository priceRepository;

    PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price priceOf(long productId) {
        return priceRepository.priceOf(productId);
    }
}
