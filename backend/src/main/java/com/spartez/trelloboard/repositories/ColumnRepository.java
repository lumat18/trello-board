package com.spartez.trelloboard.repositories;

import com.spartez.trelloboard.domain.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<Column, Long> {
    @Query(value = "select b.columns from Board b where b.id = :boardId")
    List<Column> findAllByBoardId(@Param("boardId") final Long boardId);
}
