package com.project.test.controller;

import com.project.test.entity.LocationCategory;
import com.project.test.service.SideCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class SideCategoryController {
    private final SideCategoryService sideCategoryService;
    @GetMapping("/categories")
    public ResponseDto<?> CategoryList(){
        return sideCategoryService.CategoryList();
    }
    @GetMapping("subcategories/{selectedCategory}")
    public ResponseDto<?> CategoryDetailList(@PathVariable String selectedCategory){
//        System.out.println(selectedCategory);
        return sideCategoryService.CategoryDetailList(selectedCategory);
    }
    @GetMapping("/NameList")
    public ResponseDto<Page<LocationCategory>> getHospitalsBySystemName(
            @RequestParam("systemName") String systemName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Page<LocationCategory> hospitals = sideCategoryService.getHospitalsBySystemName(systemName, page, size);
        return ResponseDto.success(hospitals);
    }
}
