package com.example.demo.service.price;

import com.example.demo.error.PricingException;
import com.example.demo.model.PriceDTO;
import com.example.demo.persistence.entity.Price;
import com.example.demo.persistence.repository.PriceRepository;
import com.example.demo.persistence.filter.EligiblePriceFilter;
import com.example.demo.persistence.specification.EligiblePriceSpecification;
import com.example.demo.service.converter.PriceToPriceDTOConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class EligiblePriceServiceImpl implements EligiblePriceService {

    private PriceRepository priceRepository;
    private PriceToPriceDTOConverter priceToPriceDTOConverter;

    @Override
    public PriceDTO findEligiblePriceByDate(String productId, String brandId, LocalDateTime date) {
        EligiblePriceFilter filter = EligiblePriceFilter.builder().productId(productId).brandId(brandId).date(date).build();
        List<Price> eligiblePrices = priceRepository.findAll(EligiblePriceSpecification.builder().eligiblePriceFilter(filter).build());

        if(eligiblePrices.isEmpty()) {
            throw new PricingException("Product does not exists or there is not an eligible price for this date");
        }

        return priceToPriceDTOConverter.convert(
                eligiblePrices.stream().sorted(Comparator.comparing(Price::getPriority).reversed()).findFirst().get());
    }
}

