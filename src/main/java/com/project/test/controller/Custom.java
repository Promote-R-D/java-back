package com.project.test.controller;

import com.project.test.entity.Integrated_lnformation;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
@Builder
public class Custom {
    Long id;
    String field;
    List<HashMap<String,List<Integrated_lnformation>>> infos;
}
