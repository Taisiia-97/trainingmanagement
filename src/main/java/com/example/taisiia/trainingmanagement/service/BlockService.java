package com.example.taisiia.trainingmanagement.service;

import com.example.taisiia.trainingmanagement.domain.dao.Block;
import com.example.taisiia.trainingmanagement.exceptions.NotFoundException;
import com.example.taisiia.trainingmanagement.repository.BlockRepository;
import com.example.taisiia.trainingmanagement.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;
    private final LessonRepository lessonRepository;

    public List<Block> getAll() {
        return blockRepository.findAll();
    }

    public Block findById(Long id) {
        return blockRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found block by id" + id));

    }

    public Block save(Block block, List<Long> lessonsIds) {

        block.setLessons(lessonRepository.findLessonsByIdIn(lessonsIds));
        blockRepository.save(block);
        return block;
    }

    @Transactional
    public void deleteById(Long id) {


        blockRepository.deleteById(id);
    }

    @Transactional
    public Block updateById(Block block, List<Long> lessonsIds, Long id) {
        var blockToUpdate = findById(id);
        blockToUpdate.setLessons(lessonRepository.findLessonsByIdIn(lessonsIds));
        blockToUpdate.setName(block.getName());
        return blockToUpdate;
    }
}
