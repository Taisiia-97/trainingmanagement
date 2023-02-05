package com.example.taisiia.trainingmanagement.repository;

import com.example.taisiia.trainingmanagement.domain.dao.Course;
import com.example.taisiia.trainingmanagement.domain.dao.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByEditionsContains(Edition edition);
}
