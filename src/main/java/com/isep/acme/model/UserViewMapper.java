package com.isep.acme.model;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserViewMapper {

    public abstract UserView toUserView(User user);
}
