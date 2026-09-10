package com.users.service;

import com.users.dto.DepartmentDto;
import com.users.dto.UsersDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UsersService {
    UsersDto createUser(UsersDto usersDto);
    UsersDto updateUser(UUID id, UsersDto usersDto);
    Page<UsersDto> getPaginatedUsers(String userName, int page, int size, String sortBy, String sortDir);
    public DepartmentDto getUserDepartmentByExactName(String userName);
}
