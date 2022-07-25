package com.ptit.newspaper.config.security;

import com.ptit.newspaper.database.model.Users;
import com.ptit.newspaper.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("NOT FOUND");
        }
        return new UserPrincipal(user);
    }
}
