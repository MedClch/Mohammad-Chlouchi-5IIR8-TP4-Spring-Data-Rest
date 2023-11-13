package com.example.tp4.Services.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Double price;
    private Double qte;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Article(String description, Double price, Double qte) {
        this.description = description;
        this.price = price;
        this.qte = qte;
    }
}
