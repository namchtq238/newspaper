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

    private Integer roles;

}
