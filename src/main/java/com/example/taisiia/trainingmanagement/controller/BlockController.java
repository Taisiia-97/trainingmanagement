package com.example.taisiia.trainingmanagement.controller;

import com.example.taisiia.trainingmanagement.domain.dto.BlockDto;
import com.example.taisiia.trainingmanagement.mapper.BlockMapper;
import com.example.taisiia.trainingmanagement.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blocks")
public class BlockController {

    private final BlockService blockService;
    private final BlockMapper blockMapper;

    @GetMapping
    public List<BlockDto> getAllBlocks() {

        return blockMapper.toListDto(blockService.getAll());
    }

    @GetMapping("/{id}")
    public BlockDto getBlockById(@PathVariable Long id) {

        return blockMapper.toDto(blockService.findById(id));
    }

    @PostMapping
    public BlockDto saveBlock(@RequestBody BlockDto blockDto) {

        return blockMapper.toDto(blockService.save(blockMapper.toDao(blockDto), blockDto.getLessonsIds()));
    }

    @PutMapping("/{id}")

    public BlockDto updateBlockById(@PathVariable Long id, @RequestBody BlockDto blockDto) {

        return blockMapper.toDto(blockService.updateById(blockMapper.toDao(blockDto), blockDto.getLessonsIds(), id));
    }

    @DeleteMapping("/{id}")
    public void deleteBlockById(@PathVariable Long id) {

        blockService.deleteById(id);
    }
}
