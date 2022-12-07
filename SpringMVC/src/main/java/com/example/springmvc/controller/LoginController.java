package com.example.springmvc.controller;

import com.example.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String signin(User user) {
        if (Objects.equals(user.getUsername(), "123") && Objects.equals(user.getPassword(), "123")) {
            log.info("登录成功！");
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
