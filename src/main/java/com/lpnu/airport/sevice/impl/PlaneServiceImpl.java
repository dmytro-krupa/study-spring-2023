package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.dto.PlaneDTO;
import com.lpnu.airport.entity.Plane;
import com.lpnu.airport.exceptions.BadRequestException;
import com.lpnu.airport.repository.PlaneRepository;
import com.lpnu.airport.sevice.PlaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;

    @Override
    public PlaneDTO create(PlaneDTO planeDTO) {
        Plane plane = new Plane();
        plane.setIsActive(true);
        plane.setModel(planeDTO.getModel());
        plane.setRowSeats(planeDTO.getRowSeats());
        plane.setNumberOfSeats(planeDTO.getNumberOfSeats());

        planeRepository.save(plane);

        return PlaneDTO.toDTO(plane);
    }

    @Override
    public PlaneDTO update(PlaneDTO planeDTO) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<PlaneDTO> findAllActive(PlaneDTO planeDTO) {
        return null;
    }

    @Override
    public PlaneDTO findById(Long id) {
        Plane plane = findEntityById(id);
        return PlaneDTO.toDTO(plane);
    }

    @Override
    public Plane findEntityById(final Long id){
        return planeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("Plane with id {%s} not found", id)));
    }
}
