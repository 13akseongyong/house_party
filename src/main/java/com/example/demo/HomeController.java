package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to My Website!");
        return "home";
    }

    @GetMapping("/next")
    public String next(Model model) {
        model.addAttribute("message", "You are on the next page!");
        return "next";
    }

    @GetMapping("/password")
    public String password() {
        return "password";
    }

    @PostMapping("/submitPassword")
    @ResponseBody
    public Map<String, Object> submitPassword(@RequestParam("password") String password) {
        Map<String, Object> response = new HashMap<>();
        if ("123".equals(password)) {  // 예제에서는 "your_password"가 올바른 비밀번호라고 가정
            response.put("success", true);
        } else {
            response.put("success", false);
        }
        return response;
    }
}
