package com.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private UUID userId;
    private String userName;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
