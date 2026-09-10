package com.users.service.impl;

import com.users.dto.ApiResponse;
import com.users.dto.DepartmentDto;
import com.users.dto.UsersDto;
import com.users.mapper.UsersMapper;
import com.users.model.Users;
import com.users.repository.UsersRepository;
import com.users.service.UsersService;
import com.util.exception.DuplicateResourceException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final UsersMapper usersMapper;
    private final RestClient mtlsRestClient;

    @Override
    @Transactional
    public UsersDto createUser(UsersDto usersDto) {
        if (userRepository.existsByUserName(usersDto.getUserName())) {
            throw new DuplicateResourceException("Username '" + usersDto.getUserName() + "' is already taken!");
        }

        Users user = usersMapper.toEntity(usersDto);
        Users savedUser = userRepository.save(user);
        return usersMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public UsersDto updateUser(UUID id, UsersDto usersDto) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUserName(usersDto.getUserName());
                    existingUser.setEmail(usersDto.getEmail());
                    Users updatedUser = userRepository.save(existingUser);
                    return usersMapper.toDto(updatedUser);
                }).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UsersDto> getPaginatedUsers(String userName, int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Users> userEntityPage;

        if (userName == null || userName.trim().isEmpty()) {
            userEntityPage = userRepository.findAll(pageable);
        } else {
            userEntityPage = userRepository.findByUserNameContainingIgnoreCase(userName, pageable);
        }

        return userEntityPage.map(usersMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentDto getUserDepartmentByExactName(String userName) {
        userRepository.findByUserName(userName)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + userName));
        return callThirdPartyApi(userName);
    }

    private DepartmentDto callThirdPartyApi(String userName) {
            ApiResponse<DepartmentDto> response = mtlsRestClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/department/getByUsername")
                            .queryParam("userName", userName)
                            .build())
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            if (response == null) {
                throw new IllegalStateException("API returned an empty response body");
            }

            if (!"SUCCESS".equalsIgnoreCase(response.getStatus())) {
                throw new RuntimeException("API Error: " + response.getMessage());
            }

            DepartmentDto departmentDto = response.getData();
            if (departmentDto == null) {
                throw new NullPointerException("API status was SUCCESS, but the department data block is missing");
            }

            return departmentDto;
    }
}
