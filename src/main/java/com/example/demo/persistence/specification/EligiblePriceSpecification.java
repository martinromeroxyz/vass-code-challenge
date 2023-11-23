package com.example.demo.persistence.specification;

import com.example.demo.persistence.entity.Brand;
import com.example.demo.persistence.entity.Price;
import com.example.demo.persistence.filter.EligiblePriceFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
@Data
public class EligiblePriceSpecification implements Specification<Price> {

    private EligiblePriceFilter eligiblePriceFilter;

    @Override
    public Predicate toPredicate(Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(eligiblePriceFilter.getProductId())) {
            predicates.add(cb.equal(root.get(Price.Fields.productId), eligiblePriceFilter.getProductId()));
        }

        if (Objects.nonNull(eligiblePriceFilter.getBrandId())) {
            predicates.add(cb.equal(root.get(Price.Fields.brand).get(Brand.Fields.brandId), eligiblePriceFilter.getBrandId()));
        }

        if(Objects.nonNull(eligiblePriceFilter.getDate())) {
            Predicate startDatePredicate = cb.lessThanOrEqualTo(root.get(Price.Fields.startDate), eligiblePriceFilter.getDate());
            Predicate endDatePredicate = cb.greaterThanOrEqualTo(root.get(Price.Fields.endDate), eligiblePriceFilter.getDate());
            predicates.add(cb.and(startDatePredicate, endDatePredicate));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
