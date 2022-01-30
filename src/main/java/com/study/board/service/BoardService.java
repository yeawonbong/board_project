package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // [JPA] Service라고 지정
public class BoardService {

    @Autowired // [Spring] 객체 생성 안해도, spring bean이 알아서 읽어와서 주입을 해준다. dependency injection
    private BoardRepository boardRepository;

    // 작성된 글 처리
    public void write(Board board) {

        boardRepository.save(board);

    }

    // 게시물 리스트 불러오기 처리
    public List<Board> boardList() {

        return boardRepository.findAll(); // list<Board>를 반환

    }

    // 특정 게시물 불러오기 처리
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 특정 게시물 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }


}
