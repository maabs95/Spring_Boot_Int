package com.department.service;

import com.department.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto getDepartmentByUserName(String userName);
}
