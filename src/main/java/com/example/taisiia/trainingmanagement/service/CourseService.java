package com.example.taisiia.trainingmanagement.service;

import com.example.taisiia.trainingmanagement.domain.dao.Course;
import com.example.taisiia.trainingmanagement.exceptions.NotFoundException;
import com.example.taisiia.trainingmanagement.repository.BlockRepository;
import com.example.taisiia.trainingmanagement.repository.CourseRepository;
import com.example.taisiia.trainingmanagement.repository.EditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final BlockRepository blockRepository;

    private final EditionRepository editionRepository;

    public Course findById(Long id) {

        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found course by id " + id));
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {

        courseRepository.deleteById(id);
    }

    public Course create(Course course, List<Long> blocksIds) {

        course.setBlocks(blockRepository.findBlockByIdIn(blocksIds));
        courseRepository.save(course);
        return course;
    }

    public Course updateById(Course course, List<Long> blocksIds, Long id) {
        var courseToUpdate = findById(id);
        courseToUpdate.setName(course.getName());
        courseToUpdate.setBlocks(blockRepository.findBlockByIdIn(blocksIds));

        return courseToUpdate;
    }

    public Course findByEditionName(String name) {
        var edition = editionRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Not found edition by name " + name));

        return courseRepository.findByEditionsContains(edition).
                orElseThrow(() -> new NotFoundException("Not found course by editon" + name));
    }
}
