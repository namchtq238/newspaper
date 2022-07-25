package com.ptit.newspaper.database.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String header;
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToMany(mappedBy = "article")
    private Set<Comment> comment;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
