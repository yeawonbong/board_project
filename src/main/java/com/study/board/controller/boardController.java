package com.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //spring이 이게 controller라는 것을 알게 하는 어토테이션
public class boardController {

    @GetMapping("/") // localhost:8080로 '/' 경로로 들어왔을 때 (안붙여도 브라우저에서 슬래시 붙여준다)
    @ResponseBody       // 글자를 그대로 띄워줄 수 있게끔 해주는 어노테이션
    public String main() {

        return "Hello World";

    }
}
