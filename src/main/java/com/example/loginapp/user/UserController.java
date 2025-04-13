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
        User sessionuser = (User) session.getAttribute("sessionUser");
        if (sessionuser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        return "user/update-form";
    }

    // Update
    @PostMapping("/update")
    public String update(UserRequest.UpdateDTO reqDTO) {
        User sessionUser = (User) session.getAttribute("model");
        if (sessionUser == null) throw new RuntimeException("로그인 후 사용해주세요.");
        User userPS = userService.update(reqDTO, sessionUser.getId());
        session.setAttribute("model", userPS);
        return "redirect:/";
    }
}
