package com.ptit.newspaper.api.req;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotNull(message = "username cannot be empty")
    private String username;

    @NotNull(message = "password cannot be empty")
    private String password;
}
