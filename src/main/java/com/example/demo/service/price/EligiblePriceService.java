package com.example.demo.service.price;

import com.example.demo.model.PriceDTO;

import java.time.LocalDateTime;

public interface EligiblePriceService {

    PriceDTO findEligiblePriceByDate(String productId, String brandId, LocalDateTime date);
}
