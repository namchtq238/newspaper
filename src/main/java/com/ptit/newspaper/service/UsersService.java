package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.UpdateUserReq;
import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UpdateUserRes;
import com.ptit.newspaper.api.res.UserResponse;
import com.ptit.newspaper.database.model.Users;

import java.util.Optional;

public interface UsersService {
    UserResponse registerAccount(UserRegisterReq req);
<<<<<<< HEAD
=======

>>>>>>> 871a5f61f2ad1915bea4c241caadb07a9f41fc1a
    UpdateUserRes update(UpdateUserReq req, Long id);


}
