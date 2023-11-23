package com.example.demo.service.converter;

import com.example.demo.model.PriceDTO;
import com.example.demo.persistence.entity.Price;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PriceToPriceDTOConverter implements Converter<Price, PriceDTO> {

    @Override
    public PriceDTO convert(Price source) {
        return PriceDTO.builder()
                .productId(source.getProductId())
                .brandId(source.getBrand().getBrandId())
                .priceList(source.getPriceList())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .price(source.getPrice())
                .currency(source.getCurrency().getCurrencyCode())
                .build();
    }
}
