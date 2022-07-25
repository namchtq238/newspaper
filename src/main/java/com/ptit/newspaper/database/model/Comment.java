package com.ptit.newspaper.database.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne()
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users users;
    private boolean isAnonymous;
}
