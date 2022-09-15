package com.hei.la_Maody.controller.mapper.model;


import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class restArticle {
    private Long id;
    private double price;
    private String category;
    private String name;
}
