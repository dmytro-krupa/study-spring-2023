package com.lpnu.airport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private int rowSeats;
    @Column
    private int numberOfSeats;
    @Column
    private Boolean isActive = Boolean.TRUE;

    @OneToOne(mappedBy = "plane")
    private Flight flight;
}
