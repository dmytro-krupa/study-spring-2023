package com.lpnu.airport.dto;

import com.lpnu.airport.entity.Plane;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaneDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String model;
    @Positive
    private Integer rowSeats;
    @Positive
    private Integer numberOfSeats;
    private Boolean isActive;



    public static PlaneDTO toDTO(final Plane plane){
        final PlaneDTO planeDTO = new PlaneDTO();

        planeDTO.setId(plane.getId());
        planeDTO.setModel(plane.getModel());
        planeDTO.setRowSeats(plane.getRowSeats());
        planeDTO.setNumberOfSeats(plane.getNumberOfSeats());
        planeDTO.setIsActive(plane.getIsActive());

        return planeDTO;
    }
}
