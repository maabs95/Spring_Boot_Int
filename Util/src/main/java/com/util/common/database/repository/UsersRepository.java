package com.util.common.database.repository;

import com.util.common.database.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUserName(String userName);
    Page<Users> findByUserNameContainingIgnoreCase(String userName, Pageable pageable);
    boolean existsByUserName(String userName);
}
