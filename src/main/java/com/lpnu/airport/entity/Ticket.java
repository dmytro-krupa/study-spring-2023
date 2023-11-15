package com.lpnu.airport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String place;

    @Column
    private BigDecimal price;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;




//    public static void main(String[] args) {
//        int x = 7;
//        int row = 6;
//        String chars = "ABCDEFGH";
//
//
//        for(int i = 1; i <= x/row + 1; i++){
//            for (int j = 0; j < row; j++){
//                //row тут неправильне
//                System.out.println("" + i + chars.charAt(j));
//            }
//        }
//    }
}
