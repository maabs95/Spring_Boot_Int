package com.users.repository;

import com.users.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUserName(String userName);
    Page<Users> findByUserNameContainingIgnoreCase(String userName, Pageable pageable);
    boolean existsByUserName(String userName);
}
