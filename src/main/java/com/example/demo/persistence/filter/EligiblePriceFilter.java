package com.example.demo.persistence.filter;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class EligiblePriceFilter {
    private String productId;
    private String brandId;
    private LocalDateTime date;
}
