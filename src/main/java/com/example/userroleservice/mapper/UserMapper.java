package com.example.userroleservice.mapper;

import com.example.userroleservice.dto.UserDto;
import com.example.userroleservice.dto.CreateUserRequest;
import com.example.userroleservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    
    UserDto toDto(User user);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "active", constant = "true")
    User toEntity(CreateUserRequest createUserRequest);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    void updateEntity(UserDto userDto, @MappingTarget User user);
} 