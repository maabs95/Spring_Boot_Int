package com.department.service.impl;

import com.department.dto.DepartmentDto;
import com.department.service.DepartmentService;
import com.util.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public DepartmentDto getDepartmentByUserName(String userName) {
        if(ObjectUtils.isEmpty(userName)){
            throw new ResourceNotFoundException("Username cannot be empty");
        }

        // For testing purpose, all username will return the same value
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setUserName(userName);
        departmentDto.setName("IT");
        departmentDto.setDescription("Handle Infra");

        return departmentDto;
    }
}
