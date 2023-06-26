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
//    public ResponseDto<?> search(SearchDto requestDto){
//        System.out.println("파람스 잘들어오냐  :  "+requestDto.getMi());
//        List<MedicalInstitution> infos=medicalInstitutionRepository.search(requestDto.getHn(),
//                requestDto.getDdo(),
//                requestDto.getSgg(),
//                requestDto.getEmd(),
//                requestDto.getMi(),
//                requestDto.getMd());
//        return ResponseDto.success(infos);
//    }
    public ResponseDto<?> searchName(SearchDto data){
        List<MedicalInstitution> byNameFuzzyMatch = medicalInstitutionRepository.findByNameFuzzyMatch(data.getHn());
        return ResponseDto.success(byNameFuzzyMatch);
    }
    public ResponseDto<?> anotherField(SearchDto data){
        List<String> distinctSiByAnotherField = medicalInstitutionRepository.findDistinctSiByAnotherField(data.getDdo());
        if(distinctSiByAnotherField==null||distinctSiByAnotherField.isEmpty()){
            return ResponseDto.fail("UPDATE_PRE",data.getDdo()+"는 업데이트 예정중입니다.");
        }
        return ResponseDto.success(distinctSiByAnotherField);
    }
    public ResponseDto<?> searchMd(SearchDto data){
        System.out.println("또 : "+data.getDdo());

        if(data.getDdo()==null||data.getDdo().isEmpty()){
            return ResponseDto.fail("NULL_POINT","행정구역을 선택해 주세요");
        }else if(data.getSi() == null || data.getSi().isEmpty()){
            return ResponseDto.fail("NULL_POINT","시군구를 선택해주세요");
        }
        if(data.getSi().equals("전체")){
            List<MedicalInstitution> byDistrictAndMedicalDepartmentAll = medicalInstitutionRepository.findByDistrictAndMedicalDepartmentAll(data.getDdo(), data.getMd());

            return ResponseDto.success(byDistrictAndMedicalDepartmentAll);
        }
        List<MedicalInstitution>byMdFuzzyMatch =medicalInstitutionRepository.findByDistrictAndMedicalDepartment(data.getDdo(), data.getSi(), data.getMd());
        if(byMdFuzzyMatch.isEmpty()){
            return ResponseDto.fail("NULL_POINT","주변에 " + data.getTitle()+"가 없습니다.");
        }
//        if(byMdFuzzyMatch.isEmpty()){
//            return ResponseDto.fail("UPDATE_PRE",data.getDdo()+"는 업데이트 예정중입니다.");
//        }
        return ResponseDto.success(byMdFuzzyMatch);
    }
    public ResponseDto<?> test(){
        return ResponseDto.success("test");
    }
}
