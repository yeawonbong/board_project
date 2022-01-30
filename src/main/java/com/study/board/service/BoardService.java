package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // [JPA] Service라고 지정
public class BoardService {

    @Autowired // [Spring] 객체 생성 안해도, spring bean이 알아서 읽어와서 주입을 해준다. dependency injection
    private BoardRepository boardRepository;

    public void write(Board board) {

        boardRepository.save(board);

    }
}
