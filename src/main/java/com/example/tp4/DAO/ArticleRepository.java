package com.example.tp4.DAO;

import com.example.tp4.Domaine.ArticleDTO;
import com.example.tp4.Services.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "articles",path = "ecommerce",excerptProjection = ArticleDTO.class)
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @RestResource(path = "byDescription",rel = "customFindByDescription")
    List<Article> findByDescription(@Param("description") String description);
}
