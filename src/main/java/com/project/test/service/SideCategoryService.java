package com.project.test.service;

import com.project.test.controller.ResponseDto;
import com.project.test.entity.LocationCategory;
import com.project.test.repository.LocationCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SideCategoryService {
    private final LocationCategoryRepository locationCategoryRepository;
    public ResponseDto<?> CategoryList(){
        List<String> distinctDetailFields = locationCategoryRepository.findDistinctDetailFields();
        return ResponseDto.success(distinctDetailFields);
    }
    public ResponseDto<?> CategoryDetailList(String selectedCategory){
        List<String> distinctSystemNamesByDetailField = locationCategoryRepository.findDistinctSystemNamesByDetailField(selectedCategory);
        return ResponseDto.success(distinctSystemNamesByDetailField);
    }

    public Page<LocationCategory> getHospitalsBySystemName(String systemName, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<LocationCategory> hospitalsBySystemName = locationCategoryRepository.findBySystemName(systemName, pageable);
        System.out.println(hospitalsBySystemName.getContent());
        return locationCategoryRepository.findBySystemName(systemName, pageable);
    }
}
