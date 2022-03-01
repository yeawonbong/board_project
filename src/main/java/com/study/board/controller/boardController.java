package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //[spring] 이게 controller라는 것을 알게 하는 어토테이션
public class boardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // 어떤 url로 접속하게 할거냐 매핑해주는 어노테이션 --> localhost:8080/board/write로 접속하면 boardwrite 페이지를 보여주겠다는 것!
    public String boardWriteForm() {

            return "boardwrite"; // 따옴표 안에, 어떤 html파일로 이동할건 지 파일명 넣기
    }

    @PostMapping("/board/writeprocess")
    public String boardWriteProcess(Board board) {

        if (boardService.write(board) == false)
            return "redirect:/board/error";
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) { // [spring] 데이터를 담아서 페이지로 보내줄 때 쓰는 Model
        model.addAttribute("list", boardService.boardList()); // 2인자를 1이름을 붙여 넘기겠다는 표현
        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1 파라미터 get방식
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/board/list"; // (redirect, 나중에 찾아볼것)
    }

    @GetMapping("/board/modify/{id}") //path variable
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public  String boardUpdate(@PathVariable("id") Integer id, Board board) {
        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());     //인자로 들어온 값 덮어씌우기
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp); // 덮어씌우기
        return "redirect:/board/list";
    }
}
