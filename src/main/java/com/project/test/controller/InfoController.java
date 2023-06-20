package com.project.test.controller;

import com.project.test.service.HmwInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class InfoController {
    private final HmwInfoService hmwInfoService;
    //보건의료복지 정보
    @GetMapping("/hmw_info/{category}")
    public ResponseDto<?> hmwInfo(@PathVariable String category){
        return hmwInfoService.category(category);
    }

}
