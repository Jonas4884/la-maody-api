package com.hei.la_Maody.controller.mapper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter

public class createRestArticle {
    private Long id;
    private double price;
    private int category;
    private String name;
}
