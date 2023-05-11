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
        List<MedicalInstitution>byMdFuzzyMatch =medicalInstitutionRepository.findByMdFuzzyMatch(data.getMd());
        return ResponseDto.success(byMdFuzzyMatch);
    }
}
