package com.users.mapper;

import com.users.dto.UsersDto;
import com.util.model.Users;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-10T10:10:33+0800",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.4.1 (Microsoft)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UsersDto toDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UsersDto usersDto = new UsersDto();

        usersDto.setUserId( user.getUserId() );
        usersDto.setUserName( user.getUserName() );
        usersDto.setEmail( user.getEmail() );
        usersDto.setActive( user.isActive() );
        usersDto.setCreatedDate( user.getCreatedDate() );
        usersDto.setUpdatedDate( user.getUpdatedDate() );

        return usersDto;
    }

    @Override
    public Users toEntity(UsersDto usersDto) {
        if ( usersDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setUserName( usersDto.getUserName() );
        users.setEmail( usersDto.getEmail() );
        users.setActive( usersDto.isActive() );
        users.setCreatedDate( usersDto.getCreatedDate() );
        users.setUpdatedDate( usersDto.getUpdatedDate() );

        return users;
    }
}
