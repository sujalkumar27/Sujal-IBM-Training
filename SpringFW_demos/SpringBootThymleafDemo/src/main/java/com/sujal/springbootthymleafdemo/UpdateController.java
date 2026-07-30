package com.sujal.springbootthymleafdemo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateController {

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("title", "Student List");
        model.addAttribute("students",
                Arrays.asList("Alice", "Bob", "Charlie", "David"));

        return "list";
    }
}
