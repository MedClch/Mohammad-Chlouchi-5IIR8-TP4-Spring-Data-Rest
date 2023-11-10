package com.example.tp4.Services;

import com.example.tp4.Services.Model.Article;
import com.example.tp4.Services.Model.Categorie;

public interface iService {
    void save(Categorie categorie, Article... articles);
}
