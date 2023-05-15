package com.project.test.service;

import com.project.test.controller.DrugDto;
import com.project.test.controller.DrugResponseDto;
import com.project.test.controller.ResponseDto;
import com.project.test.entity.ContraindicatedDrug;
import com.project.test.repository.ContraindicatedDrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContraindicatedDrugService {
    private final ContraindicatedDrugRepository contraindicatedDrugRepository;
    @Transactional
    public ResponseDto<?> drugContraindicated(DrugDto drugDto){
        //빈값 처리
        if(drugDto.getDrug1().isEmpty()||drugDto.getDrug2().isEmpty()){
            return ResponseDto.fail("NULL_NOT","약을 입력해주세요");
        }
        List<ContraindicatedDrug> contraindicatedDrugs = contraindicatedDrugRepository.findContraindicatedDrugs(drugDto.getDrug1(), drugDto.getDrug2());

        if (!contraindicatedDrugs.isEmpty()) {
            ContraindicatedDrug contraindicatedDrug = contraindicatedDrugs.get(0);
            return  ResponseDto.success(DrugResponseDto.builder()
                    .id(contraindicatedDrug.getId())
                    .ingredientCodeA(contraindicatedDrug.getIngredientA())
                    .ingredientA(contraindicatedDrug.getIngredientA())
                    .productNameA(contraindicatedDrug.getProductNameA())
                    .companyA(contraindicatedDrug.getCompanyA())
                    .ingredientB(contraindicatedDrug.getIngredientB())
                    .ingredientCodeB(contraindicatedDrug.getIngredientCodeB())
                    .productNameB(contraindicatedDrug.getProductNameB())
                    .companyB(contraindicatedDrug.getCompanyB())
                    .details(contraindicatedDrug.getDetails())
                    
                    .contraindicated(drugDto.getDrug1()+"와 "+drugDto.getDrug2()+"는(은) 범용금기약물입니다. 담당의사와 상의하세요.")
                    .build());
        } else {
            return ResponseDto.fail("DONT_DRUG", "금기약품이 아닙니다.");
        }

    }
}
