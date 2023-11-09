package com.lpnu.airport.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal money = BigDecimal.ZERO;
}
