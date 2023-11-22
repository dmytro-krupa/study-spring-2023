package com.lpnu.airport.sevice;

import com.lpnu.airport.dto.PlaneDTO;
import com.lpnu.airport.entity.Plane;

import java.util.List;

public interface PlaneService {
    List<PlaneDTO> findAllActive(PlaneDTO planeDTO);
    PlaneDTO findById(Long id);
    Plane findEntityById(Long id);
    PlaneDTO create(PlaneDTO planeDTO);
    PlaneDTO update(PlaneDTO planeDTO);
    void remove(Long id);
}
