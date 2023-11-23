package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID>, JpaSpecificationExecutor {
}
