package com.ptit.newspaper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;
    @ManyToOne()
    @JoinColumn(name = "article_id")
    private Article article;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private boolean isAnonymous;
}
