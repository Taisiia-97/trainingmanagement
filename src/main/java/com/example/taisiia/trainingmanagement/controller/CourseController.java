//package com.example.taisiia.trainingmanagement.controller;
//
//import com.example.taisiia.trainingmanagement.domain.dto.CourseDto;
//import com.example.taisiia.trainingmanagement.mapper.CourseMapper;
//import com.example.taisiia.trainingmanagement.service.CourseService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/courses")
//@RequiredArgsConstructor
//public class CourseController {
//    private final CourseService courseService;
//
//    private final CourseMapper courseMapper;
//
//    @GetMapping("/{id}")
//    public CourseDto findCourseById(@PathVariable Long id){
//
//        return courseMapper.toDto(courseService.findById(id));
//    }
//
//    @GetMapping
//    public List<CourseDto> getAllCourses(){
//        return courseMapper.toListDto(courseService.getAll());
//    }
//
//    @GetMapping
//    public CourseDto findCourseByEditionName(@RequestParam String name){
//
//        return courseMapper.toDto(courseService.findByEditionName(name));
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCourseById(@PathVariable Long id){
//
//        courseService.deleteById(id);
//    }
//
//    @PostMapping
//    public CourseDto createCourse(@RequestBody CourseDto courseDto){
//
//        return courseMapper.toDto(courseService.create(courseMapper.toDao(courseDto),courseDto.getBlocksIds()));
//    }
//
//
//    @PutMapping("/{id}")
//    public  CourseDto updateCourseById(@RequestBody CourseDto courseDto, @PathVariable Long id){
//        return courseMapper.toDto(courseService.updateById(courseMapper.toDao(courseDto),courseDto.getBlocksIds(),id));
//    }
//
//
//}
