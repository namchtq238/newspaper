package com.ptit.newspaper.api.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    Long id;
    String username;
    String address;
    String phoneNumber;
}
