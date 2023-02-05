package com.example.taisiia.trainingmanagement.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;

    private String name;


    private List<BlockDto> blocks;

    private List<EditionDto> editions;


    private List<Long> blocksIds;
}
