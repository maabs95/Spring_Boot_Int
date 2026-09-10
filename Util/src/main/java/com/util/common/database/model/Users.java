package com.util.common.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "UserID", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "UserName", length = 100, nullable = false)
    private String userName;

    @Column(name = "Email", length = 255, nullable = false)
    private String email;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @CreatedDate
    @Column(name = "CreatedDate", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "UpdatedDate", nullable = false)
    private LocalDateTime updatedDate;
}