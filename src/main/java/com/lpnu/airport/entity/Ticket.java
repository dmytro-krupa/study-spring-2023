package com.lpnu.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Long id;
    private User user;
    private String place;
    private Flight flight;
    private BigDecimal price;
}
