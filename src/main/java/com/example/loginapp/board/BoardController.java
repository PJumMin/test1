package com.example.loginapp.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final HttpSession session;

    // ListPage
    @GetMapping("/")
    public String list(HttpServletRequest request) {
        List<Board> storeList = boardService.storeList();
        request.setAttribute("models", storeList);
        return "board/list";
    }


}
