package com.ptit.newspaper.api.controller;

import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;
    @PostMapping("/add-category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest){
        try {
            return ResponseEntity.ok().body(adminService.createCategory(categoryRequest));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/list-category")
    public ResponseEntity<?> getCategory(){
        try{
            return ResponseEntity.ok().body(adminService.getListCategory());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryRequest req,@PathVariable(value = "id") Long id) {
        try {
            return  ResponseEntity.ok(adminService.updateCategory(req,id));
            // return ResponseEntity.ok().body(adminService.createCategory(categoryRequest));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){

        try{
            return ResponseEntity.ok().body(adminService.deleteCategory(id));
    @GetMapping("/list-user")
    public ResponseEntity<?> getUser(){
        try{
            return ResponseEntity.ok().body(adminService.getListUser());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try{
            return ResponseEntity.ok().body(adminService.deleteUser(id));
        } catch (Exception e){
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
