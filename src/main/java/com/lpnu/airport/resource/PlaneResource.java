package com.lpnu.airport.resource;

import com.lpnu.airport.dto.PlaneDTO;
import com.lpnu.airport.sevice.PlaneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plane")
@RequiredArgsConstructor
public class PlaneResource {

    private final PlaneService planeService;

    @PostMapping
//    public PlaneDTO createPlane(final @Valid PlaneDTO planeDTO){
    public PlaneDTO createPlane(final @RequestBody @Valid PlaneDTO planeDTO){
        return planeService.create(planeDTO);
    }

}
