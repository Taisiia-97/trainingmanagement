package com.example.taisiia.trainingmanagement.repository;

import com.example.taisiia.trainingmanagement.domain.dao.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block,Long> {


    List<Block> findBlockByIdIn(List<Long> ids);
}
