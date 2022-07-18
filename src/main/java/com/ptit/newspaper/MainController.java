package com.ptit.newspaper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<?> homepage(){
        return ResponseEntity.ok("homepage");
    }
}
