package com.example.taisiia.trainingmanagement.repository;

import com.example.taisiia.trainingmanagement.domain.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

}
