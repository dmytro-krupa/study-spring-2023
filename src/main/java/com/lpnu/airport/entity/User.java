package com.lpnu.airport.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
}
