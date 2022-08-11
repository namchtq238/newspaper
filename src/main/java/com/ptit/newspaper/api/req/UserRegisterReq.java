package com.ptit.newspaper.api.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterReq {
    private Long id;

    private String username;

    private String password;

    private String address;

    private String phoneNumber;

    private Integer roles;

}