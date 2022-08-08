package com.ptit.newspaper.api.res;

import com.ptit.newspaper.database.model.Category;
import com.ptit.newspaper.database.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {
    Long id;
    String header;
    String body;
    String users_name;

}
