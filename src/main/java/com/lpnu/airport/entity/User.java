package com.lpnu.airport.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private BigDecimal money = BigDecimal.ZERO;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}
