package com.ptit.newspaper.api.req;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserReq {

    private String username;

    private String address;

    private String phoneNumber;
<<<<<<< HEAD
=======

    private Integer roles;
>>>>>>> 871a5f61f2ad1915bea4c241caadb07a9f41fc1a
}
