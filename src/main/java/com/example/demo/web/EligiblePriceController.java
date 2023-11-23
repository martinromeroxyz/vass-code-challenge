package com.example.demo.web;

import com.example.demo.api.EligibleProductPriceApi;
import com.example.demo.model.PriceDTO;
import com.example.demo.service.price.EligiblePriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class EligiblePriceController implements EligibleProductPriceApi {

    private EligiblePriceService eligiblePriceService;

    @Override
    public ResponseEntity<PriceDTO> _findEligiblePriceByDate(String productId, String brandId, LocalDateTime date) {
        return ResponseEntity.ok(eligiblePriceService.findEligiblePriceByDate(productId, brandId, date));
    }
}

