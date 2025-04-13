package com.example.loginapp.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // JoinPage
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    // Join
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO reqDTO) {
        userService.join(reqDTO);
        return "redirect:/login-form";
    }

    // LoginPage
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    // Login
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        User sessionUser = userService.login(reqDTO);
        session.setAttribute("model", sessionUser);
        return "redirect:/";
    }

    // Logout
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    // UpdatePage
    @GetMapping("/update-form")
    public String updateForm() {
        return "user/update-form";
    }

    // Update
    @PostMapping("/update")
    public String update(UserRequest.UpdateDTO reqDTO) {
        System.out.println("1");
        User sessionUser = (User) session.getAttribute("model");
        System.out.println("2");
        System.out.println(sessionUser);
        User userPS = userService.update(reqDTO, sessionUser.getId());
        System.out.println("3");
        session.setAttribute("model", userPS);
        return "redirect:/";
    }
}
