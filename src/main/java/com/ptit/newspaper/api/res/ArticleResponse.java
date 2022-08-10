package com.ptit.newspaper.api.res;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {
    Long id;
    String header;
    String body;
    CategoryResponse category;
    UserResponse users;

}
