package com.project.test.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugResponseDto {
    private Long id;
    private String ingredientA;
    private String ingredientCodeA;
    private String productNameA;
    private String companyA;
    private String ingredientB;
    private String ingredientCodeB;
    private String productNameB;
    private String companyB;

    private String details;
    private  String contraindicated;
}
