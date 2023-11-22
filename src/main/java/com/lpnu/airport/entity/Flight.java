package com.lpnu.airport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @Column
    private Boolean isActive = Boolean.TRUE;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @OneToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;
}
