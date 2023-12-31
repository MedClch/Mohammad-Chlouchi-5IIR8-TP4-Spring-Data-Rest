package com.example.tp4;

import com.example.tp4.Services.Model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestArticles {
    @Autowired
    WebApplicationContext context;
    private MockMvc mvc;

    @BeforeEach
    void setUp(){
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void testGetAllArticles() throws Exception {
        mvc.perform(get("/ecommerce").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.articles[0].desc").value("Article_1"))
                .andExpect(jsonPath("$._embedded.articles[1].price").value(6000))
                .andExpect(jsonPath("$._embedded.articles[2].qte").value(44));
    }


    @Test
    void testGetArticleById() throws Exception{
        Article article = new Article("Article_1",120d,10d);
        mvc.perform(get("/ecommerce/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.description").value("Article_1"))
                .andExpect(jsonPath("$.price").value(120d))
                .andExpect(jsonPath("$.qte").value(10d));
    }
}
