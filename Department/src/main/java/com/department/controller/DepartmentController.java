package com.department.controller;

import com.department.service.DepartmentService;
import com.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    private ResponseDto setResponseDto(Object result) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("SUCCESS");
        responseDto.setData(result);

        return responseDto;
    }

    @GetMapping("/getByUsername")
    public ResponseEntity<ResponseDto> getDepartmentByUsername(@RequestParam String userName) {
        return ResponseEntity.ok(setResponseDto(departmentService.getDepartmentByUserName(userName)));
    }
}
