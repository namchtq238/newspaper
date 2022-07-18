package com.ptit.newspaper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<?> homepage(){
        return ResponseEntity.ok("homepage");
    }
}
