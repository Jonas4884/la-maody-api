package com.hei.la_Maody.controller.mapper;

import com.hei.la_Maody.controller.mapper.model.restArticle;
import com.hei.la_Maody.model.article;
import org.springframework.stereotype.Component;

@Component
public class articleMapper {
    public static restArticle toRest(article article){
        return restArticle.builder()
                .id(article.getId())
                .price(article.getPrice())
                .category(article.getCategory().getLabel())
                .name(article.getName())
                .build();
    }
}
