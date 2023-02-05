package com.example.taisiia.trainingmanagement.service;

import com.example.taisiia.trainingmanagement.domain.dao.Lesson;
import com.example.taisiia.trainingmanagement.exceptions.NotFoundException;
import com.example.taisiia.trainingmanagement.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> getAll() {

        return lessonRepository.findAll();
    }

    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found lesson by id" + id));
    }

    @Transactional
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson save(Lesson lesson) {

        return lessonRepository.save(lesson);
    }

    @Transactional
    public Lesson updateById(Lesson lesson, Long id) {

        var lessonToUpdate = findById(id);

        lessonToUpdate.setTopic(lesson.getTopic());
        lessonToUpdate.setDate(lesson.getDate());

        return lessonToUpdate;


    }
}
