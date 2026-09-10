package com.users.mapper;

import com.users.dto.UsersDto;
import com.util.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDto toDto(Users user);

    @Mapping(target = "userId", ignore = true)
    Users toEntity(UsersDto usersDto);
}
