package com.ptit.newspaper.api.controller.web;

import com.ptit.newspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<?> getArticle(){
        try{
            return ResponseEntity.ok().body(articleService.getListArticle());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
