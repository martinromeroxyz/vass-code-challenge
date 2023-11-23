package com.example.demo.error;

public class PricingException extends RuntimeException {
    public PricingException(String s) {
        super( s );
    }
}
