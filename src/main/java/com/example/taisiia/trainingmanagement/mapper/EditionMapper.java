package com.example.taisiia.trainingmanagement.mapper;

import com.example.taisiia.trainingmanagement.domain.dao.Edition;
import com.example.taisiia.trainingmanagement.domain.dto.EditionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditionMapper {

    Edition toDao(EditionDto editionDto);

    EditionDto toDto(Edition edition);

    List<EditionDto> toListDto(List<Edition> editions);
}
