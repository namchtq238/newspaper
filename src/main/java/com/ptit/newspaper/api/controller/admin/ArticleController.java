package com.ptit.newspaper.api.controller.admin;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/admin/article")
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

    @PostMapping
    ResponseEntity<?> createArticle(@RequestBody ArticleRequest articleRequest){

        try {
            return ResponseEntity.ok().body(articleService.createArticle(articleRequest));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateArticle(@RequestBody ArticleRequest articleRequest, @PathVariable Long id){
        try {
            return ResponseEntity.ok().body(articleService.updateArticle(articleRequest,id));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteArticle(@PathVariable Long id){

        try{
            return ResponseEntity.ok().body(articleService.deleteArticle(id));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
