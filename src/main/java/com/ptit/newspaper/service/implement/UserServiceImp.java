package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.UpdateUserReq;
import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UpdateUserRes;
import com.ptit.newspaper.api.res.UserResponse;
import com.ptit.newspaper.database.mapper.UserMapper;
import com.ptit.newspaper.database.model.Users;
import com.ptit.newspaper.database.repository.UserRepository;
import com.ptit.newspaper.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImp implements UsersService {
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;
    UserMapper userMapper;


    @Override
    public UserResponse registerAccount(UserRegisterReq req) {
        Users newUser = userMapper.registerToEntity(req);
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepository.save(newUser);
        return userMapper.entityToResponse(newUser);
    }


    @Override
    public UpdateUserRes update(UpdateUserReq req, Long id) {
        Users newUser = userMapper.updateToEntity(req);
        Users oldUser= userRepository.findById(id).orElse(null);
        if(oldUser != null){
            oldUser.setUsername(newUser.getUsername());
            oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            oldUser.setAddress(newUser.getAddress());
            oldUser.setPhoneNumber(newUser.getPhoneNumber());
            return userMapper.entity(userRepository.save(oldUser));
        }
        return userMapper.entity(userRepository.save(newUser));
    }


}
