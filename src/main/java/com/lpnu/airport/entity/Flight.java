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
    @GeneratedValue
    private Long id;
    @Column
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;
}
