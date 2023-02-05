package com.example.taisiia.trainingmanagement.mapper;

import com.example.taisiia.trainingmanagement.domain.dao.Block;
import com.example.taisiia.trainingmanagement.domain.dto.BlockDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {LessonMapper.class})
public interface BlockMapper {



    BlockDto toDto(Block block);


    Block toDao(BlockDto blockDto);

    List<BlockDto> toListDto(List<Block> blocks);

}
