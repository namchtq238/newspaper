package com.ptit.newspaper.database.model;

import com.ptit.newspaper.constant.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "users")
    private Set<Article> article;
    @OneToMany(mappedBy = "users")
    private Set<Comment> comment;
    private Roles roles;

}
