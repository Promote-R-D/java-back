package com.project.test.service;

import com.project.test.controller.ResponseDto;
import com.project.test.entity.Category;
import com.project.test.entity.Integrated_lnformation;
import com.project.test.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HmwInfoService {
    HashMap<String,List<Integrated_lnformation>> test =new HashMap<>();
    private final CategoryRepository categoryRepository;
//    @Transactional
//    public ResponseDto<?> category(String category){
//        Optional<Category> byCategory = categoryRepository.findByField(category);
//
//        for (Integrated_lnformation a:byCategory.get().getInfos()){
//            test.put(a.getDetailField(), Collections.singletonList(a));
//        }
//        System.out.println(test);
//        Custom build = Custom.builder().id(byCategory.get().getId()).field(byCategory.get().getField())
//                .infos(Collections.singletonList(test)).build();
//
//        return ResponseDto.success(build);
//    }
    @Transactional
    public ResponseDto<?> category(String category){
        System.out.println(category);
        Optional<Category> byCategory = categoryRepository.findByField(category);
        System.out.println("데이터"+byCategory);
        return ResponseDto.success(byCategory);
    }
}
