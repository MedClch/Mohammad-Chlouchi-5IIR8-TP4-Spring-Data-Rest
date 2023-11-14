package com.example.tp4.Services;

import com.example.tp4.DAO.CategorieRepository;
import com.example.tp4.Services.Model.Article;
import com.example.tp4.Services.Model.Categorie;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class iServiceImpl implements iService{
    private CategorieRepository categorieRepository;

    @Override
    public void save(Categorie categorie, Article... articles) {
        for(Article a: articles){
            a.setCategorie(categorie);
            categorie.getArticles().add(a);
        }
        categorieRepository.save(categorie);
    }
}
