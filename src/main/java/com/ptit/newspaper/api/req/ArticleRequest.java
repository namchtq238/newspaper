package com.ptit.newspaper.api.req;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleRequest {
    String header;
    String body;
    Long usersId;
    Long categoryId;
}
