package com.ptit.newspaper.model;

import com.ptit.newspaper.constant.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private Set<Article> article;
    @OneToMany(mappedBy = "user")
    private Set<Comment> comment;
    private Role role;
}
