package com.isep.acme.model.mappers;

import com.isep.acme.model.User;
import com.isep.acme.model.views.UserView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserViewMapper {

    public abstract UserView toUserView(User user);
}
