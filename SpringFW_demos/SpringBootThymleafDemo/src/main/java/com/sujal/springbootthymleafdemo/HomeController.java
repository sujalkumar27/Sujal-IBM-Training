package com.sujal.springbootthymleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Thymeleaf Demo");
        model.addAttribute("message", "Welcome to Thymeleaf!");

        return "home";
    }
}