package com.example.tp4.Domaine;

import com.example.tp4.Services.Model.Article;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "articleDAO",types = Article.class)
public interface ArticleDTO {
    Long getId();
    @Value("#{target.description}")
    String getDesc();
    Double getPrice();
    @Value("#{target.qte}")
    Double getQte();
    @Value("#{target.categorie.categorie}")
    String getCat();
}
