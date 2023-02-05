package com.example.taisiia.trainingmanagement.mapper;

import com.example.taisiia.trainingmanagement.domain.dao.Lesson;
import com.example.taisiia.trainingmanagement.domain.dto.LessonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson toDao(LessonDto lessonDto);


    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    LessonDto toDto(Lesson lesson);


    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<LessonDto> toListDto(List<Lesson> lessons);
}
