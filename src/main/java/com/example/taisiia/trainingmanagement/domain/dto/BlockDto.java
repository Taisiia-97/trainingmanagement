package com.example.taisiia.trainingmanagement.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDto {
    private Long id;
    private String name;

    private List<LessonDto> lessons;

    private List<Long> lessonsIds;
}
