package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // [JPA] repository라고 지정
public interface BoardRepository extends JpaRepository<Board, Integer > { //JPA의 repository 상속, 제너릭 타입 지정(entity type, id type)
}
