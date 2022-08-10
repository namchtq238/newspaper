package com.ptit.newspaper.database.mapper;

import com.ptit.newspaper.api.req.UpdateUserReq;
import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UpdateUserRes;
import com.ptit.newspaper.api.res.UserResponse;
import com.ptit.newspaper.database.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users registerToEntity(UserRegisterReq userRegisterReq);
    UserResponse entityToResponse(Users users);
    Users updateToEntity(UpdateUserReq updateUserReq);

    UpdateUserRes entity(Users users);
}
