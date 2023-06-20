package com.project.test.controller;


import com.project.test.service.GisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class GisController {
    private final GisService gisService;
    @GetMapping("miInfo")
    public ResponseDto<?> medicalInstitution(){
        return gisService.mIInfo();
    }
    @GetMapping("miInfo/ch")
    public ResponseDto<?> medicalInstitutionCh(){
        return gisService.mIInfoCh();
    }

    @GetMapping("miInfo/search")
    public ResponseDto<?> medicalInstitutionSearch(){
        return null;
    }


}
