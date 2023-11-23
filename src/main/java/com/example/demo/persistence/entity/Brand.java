package com.example.demo.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Entity
@Table( name = "BRANDS" )
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@FieldNameConstants
public class Brand {
    @Id
    private String brandId;

    @Column(unique = true)
    private String brandName;
}
