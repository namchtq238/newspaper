package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UserResponse;
import com.ptit.newspaper.database.mapper.UserMapper;
import com.ptit.newspaper.database.model.Users;
import com.ptit.newspaper.database.repository.UserRepository;
import com.ptit.newspaper.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UsersService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public UserResponse registerAccount(UserRegisterReq req) {
        Users newUser = userMapper.registerToEntity(req);
        userRepository.save(newUser);
        return userMapper.entityToResponse(newUser);
    }
}
