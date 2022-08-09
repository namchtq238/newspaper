package com.ptit.newspaper.api.req;

import com.ptit.newspaper.constant.Roles;
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

<<<<<<< HEAD
    private Roles roles;
=======
    private Integer roles;
>>>>>>> 871a5f61f2ad1915bea4c241caadb07a9f41fc1a

}