package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //spring이 이게 controller라는 것을 알게 하는 어토테이션
public class boardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // 어떤 url로 접속하게 할거냐 매핑해주는 어노테이션 --> localhost:8080/board/write로 접속하면 boardwrite 페이지를 보여주겠다는 것!
    public String boardWriteForm() {

            return "boardwrite"; // 따옴표 안에, 어떤 html파일로 이동할건 지 파일명 넣기

    }

    @PostMapping("/board/writeprocess")
    public String boardWriteProcess(Board board) {

        boardService.write(board);
        return "";
    }
}
