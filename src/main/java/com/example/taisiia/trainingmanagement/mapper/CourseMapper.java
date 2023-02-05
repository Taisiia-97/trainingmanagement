package com.example.taisiia.trainingmanagement.mapper;

import com.example.taisiia.trainingmanagement.domain.dao.Course;
import com.example.taisiia.trainingmanagement.domain.dto.CourseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BlockMapper.class, EditionMapper.class, LessonMapper.class})
public interface CourseMapper {

    Course toDao(CourseDto courseDto);

    CourseDto toDto(Course course);

    List<CourseDto> toListDto(List<Course> courses);


}
