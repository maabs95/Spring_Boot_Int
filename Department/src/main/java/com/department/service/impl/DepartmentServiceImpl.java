package com.department.service.impl;

import com.department.dto.DepartmentDto;
import com.department.service.DepartmentService;
import com.util.exception.ResourceNotFoundException;
import com.util.exception.UserInactiveException;
import com.util.model.Users;
import com.util.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final UsersRepository userRepository;

    @Override
    public DepartmentDto getDepartmentByUserName(String userName) {
        if(ObjectUtils.isEmpty(userName)){
            throw new ResourceNotFoundException("Username cannot be empty");
        }

        Users users = userRepository.findByUserName(userName)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + userName));
        if(!users.isActive()){
            throw new UserInactiveException("User is not active.");
        }

        // For testing purpose, all username will return the same value
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setUserName(userName);
        departmentDto.setName("IT");
        departmentDto.setDescription("Handle Infra");

        return departmentDto;
    }
}
