package com.project.test.controller;

import com.project.test.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseDto<?> Search(SearchDto requestDto){
        return searchService.search(requestDto);
    }

    @PostMapping("/nameSearch")
    public ResponseDto<?> nameSearch(
            @RequestBody
             SearchDto data){
        System.out.println(data.getHn());
        return searchService.searchName(data);
    }
    @PostMapping("/mdSearch")
    public ResponseDto<?> mdSearch(
            @RequestBody
            SearchDto data){
        System.out.println(data.getMd());
        return searchService.searchMd(data);
    }
}
