package com.ptit.newspaper.api.res;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    String token;
    String username;
    String roles;
    Long userId;
}