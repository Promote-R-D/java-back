package com.project.test.controller;

import com.project.test.service.ContraindicatedDrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class ContraindicatedDrugController {
   private final ContraindicatedDrugService contraindicatedDrugService;
    @PostMapping("/drug")
    public ResponseDto<?> bannedDrugs(@RequestBody DrugDto drugDto){
            return contraindicatedDrugService.drugContraindicated(drugDto);
    }
}
