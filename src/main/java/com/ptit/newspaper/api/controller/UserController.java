package com.ptit.newspaper.api.controller;

import com.ptit.newspaper.api.req.LoginRequest;
import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.LoginResponse;
import com.ptit.newspaper.config.jwt.JwtUtils;
import com.ptit.newspaper.config.security.UserPrincipal;
import com.ptit.newspaper.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class UserController {
    UsersService usersService;
    AuthenticationManager authenticate;
    JwtUtils jwtUtils;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginRequest req){
        try{
            Authentication authentication = authenticate.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();

            return ResponseEntity.ok(new LoginResponse(jwt, userDetails.getUsername(),
                    userDetails.getRole(), userDetails.getUser().getId()));
        }
        catch (Exception exception){
            return ResponseEntity.internalServerError().body(String.format("Code Error: %s ", exception.getLocalizedMessage()));
        }
    }

    @PostMapping("/create-account")
    public ResponseEntity<?> adminCreatedAccount(@RequestBody UserRegisterReq req){
        try{
            return ResponseEntity.accepted().body(usersService.registerAccount(req));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
