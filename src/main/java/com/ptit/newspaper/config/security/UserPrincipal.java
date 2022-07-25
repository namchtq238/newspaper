package com.ptit.newspaper.config.security;

import com.ptit.newspaper.constant.Roles;
import com.ptit.newspaper.database.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private final Users user;

    public UserPrincipal(Users user) {
        this.user = user;
    }


    public  String getRole() {
        Integer roleInInt = user.getRoles().getValue();
        if (roleInInt == null) return "";
        return Roles.valueOfType(roleInInt).toString();
    }

    public Long getId() {
        return user.getId();
    }

    public String getPhone() {
        return user.getPhoneNumber();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(getRole()));
    }

    public Users getUser() {
        return this.user;
    }

}

