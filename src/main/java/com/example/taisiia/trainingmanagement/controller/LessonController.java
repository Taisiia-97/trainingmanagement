package com.example.taisiia.trainingmanagement.controller;

import com.example.taisiia.trainingmanagement.domain.dto.LessonDto;
import com.example.taisiia.trainingmanagement.mapper.LessonMapper;
import com.example.taisiia.trainingmanagement.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    private final LessonMapper lessonMapper;



    @PreAuthorize("isAuthenticated() && hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<LessonDto> getAllLessons(){

        return lessonMapper.toListDto(lessonService.getAll());
    }

    @GetMapping("/{id}")
    public LessonDto getLessonById(@PathVariable Long id){

        return lessonMapper.toDto(lessonService.findById(id));
    }

    @PostMapping
    public LessonDto saveLesson(@RequestBody LessonDto lessonDto){

        return lessonMapper.toDto(lessonService.save(lessonMapper.toDao(lessonDto)));
    }

    @PutMapping("/{id}")

    public LessonDto updateLessonById(@PathVariable Long id, @RequestBody LessonDto lessonDto){

       return lessonMapper.toDto(lessonService.updateById(lessonMapper.toDao(lessonDto),id));
    }
    @DeleteMapping("/{id}")
    public void  deleteLessonById(@PathVariable Long id){

        lessonService.deleteById(id);
    }

}
