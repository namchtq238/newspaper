package com.ptit.newspaper.database.mapper;

import com.ptit.newspaper.api.req.UpdateUserReq;
import com.ptit.newspaper.api.req.UserRegisterReq;
import com.ptit.newspaper.api.res.UpdateUserRes;
import com.ptit.newspaper.api.res.UserResponse;
import com.ptit.newspaper.constant.Roles;
import com.ptit.newspaper.database.model.Users;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    @Mapping(target = "roles", source = "roles", qualifiedByName = "integerToRole")
    Users registerToEntity(UserRegisterReq userRegisterReq);
    UserResponse entityToResponse(Users users);
    @Mapping(target = "roles", source = "roles", qualifiedByName = "integerToRole")

    Users updateToEntity(UpdateUserReq updateUserReq);
    UpdateUserRes entity(Users users);

    @Named("integerToRole")
    public static Roles integerToRole(Integer integer){
        return Roles.valueOfType(integer);
    }
}
