package com.example.tp4;

import com.example.tp4.Services.Model.Article;
import com.example.tp4.Services.Model.Categorie;
import com.example.tp4.Services.iService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class Tp4Application {
    private iService service;

    public static void main(String[] args) {
        SpringApplication.run(Tp4Application.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase() throws Exception{
        return (a)->{
            var cat1 = new Categorie("Categorie_1");
            var cat2 = new Categorie("Categorie_2");
            var cat3 = new Categorie("Categorie_3");
            var article1 = new Article("Article_1",120d,10d);
            var article2 = new Article("Article_2",6000d,30d);
            var article3 = new Article("Article_3",7000d,44d);
            var article4 = new Article("Article_4",12000.0,5d);
            var article5 = new Article("Article_5",12000.0,5d);
            service.save(cat1,article1,article2);
            service.save(cat2,article3,article4);
            service.save(cat3,article5);
        };
    }
}
