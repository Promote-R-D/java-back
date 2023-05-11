package com.project.test.controller;

import com.project.test.repository.MedicalInstitutionRepository;
import com.project.test.service.GisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {
    private final GisService gisService;

    @PostMapping("/locationTo/{km}")
    public ResponseDto<?> locationTo(@RequestBody LocationDto locationDto,
                                     @PathVariable Long km){
        System.out.println(locationDto.getLat());
        System.out.println(locationDto.getLng());
        return gisService.locationTo(locationDto,km);
    }
}
