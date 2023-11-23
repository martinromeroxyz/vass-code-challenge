package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
@Aspect
@Slf4j
public class AuditAspect {

    @Before(value = "execution(* com.example.demo.service.price.EligiblePriceServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Start request to " + joinPoint.getSignature().getName() + " started at " + Timestamp.from(Instant.now()));
    }

    @After(value = "execution(* com.example.demo.service.price.EligiblePriceServiceImpl.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("End request to " + joinPoint.getSignature().getName() + " ended at " + Timestamp.from(Instant.now()));
    }
}
