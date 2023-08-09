package com.project.test.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    private String ddo;
    private String si;
    private String emd;
    private String mi;
    private String hn;
    private String md;
    private String title;
}
