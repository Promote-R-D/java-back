package com.project.test.service;

import com.project.test.controller.ResponseDto;
import com.project.test.controller.SearchDto;
import com.project.test.entity.MedicalInstitution;
import com.project.test.repository.MedicalInstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final MedicalInstitutionRepository medicalInstitutionRepository;
    public ResponseDto<?> search(SearchDto requestDto){
        System.out.println("파람스 잘들어오냐  :  "+requestDto.getMi());
        List<MedicalInstitution> infos=medicalInstitutionRepository.search(requestDto.getHn(),
                requestDto.getDdo(),
                requestDto.getSgg(),
                requestDto.getEmd(),
                requestDto.getMi(),
                requestDto.getMd());
        return ResponseDto.success(infos);
    }
    public ResponseDto<?> searchName(SearchDto data){
        List<MedicalInstitution> byNameFuzzyMatch = medicalInstitutionRepository.findByNameFuzzyMatch(data.getHn());
        return ResponseDto.success(byNameFuzzyMatch);
    }
    public ResponseDto<?> searchMd(SearchDto data){
//        System.out.println("또 : "+data.getDdo());
        if(data.getDdo()==null){
            return ResponseDto.fail("NULL_POINT","행정구역을 선택해 주세요");
        }else if(data.getDdo().isEmpty()){
            return ResponseDto.fail("UPDATE_PRE","행정구역을 선택해 주세요");
        }
        List<MedicalInstitution>byMdFuzzyMatch =medicalInstitutionRepository.findByDistrictAndMedicalDepartment(data.getDdo(), data.getMd());
        if(byMdFuzzyMatch.isEmpty()){
            return ResponseDto.fail("UPDATE_PRE",data.getDdo()+"는 업데이트 예정중입니다.");
        }
        return ResponseDto.success(byMdFuzzyMatch);
    }
    public ResponseDto<?> test(){
        return ResponseDto.success("test");
    }
}
