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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UserServiceImp implements UsersService {

    @Autowired
    private UserRepository userRepository;
<<<<<<< HEAD
    @Autowired
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

=======
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

>>>>>>> 871a5f61f2ad1915bea4c241caadb07a9f41fc1a


    @Override
    public UserResponse registerAccount(UserRegisterReq req) {
        Users newUser = userMapper.registerToEntity(req);
        userRepository.save(newUser);
        return userMapper.entityToResponse(newUser);
    }


    @Override
    public UpdateUserRes update(UpdateUserReq req, Long id) {
        Users newUser = userMapper.updateToEntity(req);
        Users oldUser= userRepository.findById(id).orElse(null);
        if(oldUser != null){
            oldUser.setUsername(newUser.getUsername());
            //oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            oldUser.setAddress(newUser.getAddress());
            oldUser.setPhoneNumber(newUser.getPhoneNumber());
            return userMapper.entity(userRepository.save(oldUser));
        }
        return userMapper.entity(userRepository.save(newUser));
    }


}
