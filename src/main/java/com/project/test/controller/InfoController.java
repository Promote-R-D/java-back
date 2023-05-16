package com.project.test.controller;

import com.project.test.service.HmwInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
