package com.example.tp4.Services.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Categorie {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String categorie;
    @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    public Categorie(String categorie) {
        this.categorie = categorie;
    }

    public void addArticle(Article article) {
        article.setCategorie(this);
        articles.add(article);
    }
}
