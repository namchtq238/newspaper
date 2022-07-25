package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UserResponse;

public interface UsersService {
    UserResponse registerAccount(UserRegisterReq req);
}
