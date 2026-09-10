package com.users.controller;

import com.users.dto.UsersDto;
import com.users.service.UsersService;
import com.util.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    private ResponseDto setResponseDto(Object result) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("SUCCESS");
        responseDto.setData(result);

        return responseDto;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UsersDto usersDto) {
        UsersDto savedUser = usersService.createUser(usersDto);
        return ResponseEntity.ok(setResponseDto(savedUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable UUID id, @RequestBody UsersDto usersDto) {
        return ResponseEntity.ok(setResponseDto(usersService.updateUser(id, usersDto)));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getUsersByPagination(
            @RequestParam(required = false) String userName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {

        Page<UsersDto> paginatedDto = usersService.getPaginatedUsers(userName, page, size, sortBy, sortDir);
        return ResponseEntity.ok(setResponseDto(paginatedDto));
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<ResponseDto> getUserDepartmentByExactName(@PathVariable String userName) {
        return ResponseEntity.ok(setResponseDto(usersService.getUserDepartmentByExactName(userName)));
    }
}
