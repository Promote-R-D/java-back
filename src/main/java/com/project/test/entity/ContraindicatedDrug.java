package com.project.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContraindicatedDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ingredient_a")
    private String ingredientA;
    @Column(name = "ingredient_code_a")
    private String ingredientCodeA;
    @Column(name = "product_name_a")
    private String productNameA;
    @Column(name = "company_a")
    private String companyA;
    @Column(name = "ingredient_b")
    private String ingredientB;
    @Column(name = "ingredient_code_b")
    private String ingredientCodeB;
    @Column(name = "product_name_b")
    private String productNameB;
    @Column(name = "company_b")
    private String companyB;

    private String details;
}
