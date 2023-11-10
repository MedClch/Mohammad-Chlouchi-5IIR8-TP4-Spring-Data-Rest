package com.example.tp4.DAO;

import com.example.tp4.Services.Model.Categorie;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categories",path = "categories")
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie findByCategorie(@Param("categorie") String categorie);
}
