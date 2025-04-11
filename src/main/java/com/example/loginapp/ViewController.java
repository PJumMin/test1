package com.example.loginapp;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ViewController {

    @GetMapping("/t1")
    public String t1() {
        return "board/list";
    }

    @GetMapping("/t2")
    public String t2() {
        return "user/join-form";
    }

    @GetMapping("/t3")
    public String t3() {
        return "user/login-form";
    }

    @GetMapping("/t4")
    public String t4() {
        return "user/update-form";
    }

}
