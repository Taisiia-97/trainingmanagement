package com.example.taisiia.trainingmanagement.repository;

import com.example.taisiia.trainingmanagement.domain.dao.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EditionRepository extends JpaRepository<Edition, Long> {

   Optional<Edition> findByName(String name);
}
