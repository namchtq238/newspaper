package com.ptit.newspaper.api.req;

import com.ptit.newspaper.database.model.Category;
import com.ptit.newspaper.database.model.Users;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleRequest {
    String header;
    String body;
    Long users_id;
    Long category_id;
}
