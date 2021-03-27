package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {

        List<String> names = new ArrayList<>();

        names.add("Sam");
        names.add("Dorian");
        names.add("Diego");

        model.addAttribute("aName", name.toUpperCase());
        model.addAttribute("admin", name.equals("fer"));
        model.addAttribute("nameList", names);

        return "hello";
    }

    @GetMapping("/join")
    public String renderForm(){
        return "join";
    }

    @PostMapping("/join")
    public String submitForm(
            @RequestParam(name = "cohort") String cohort,
            Model viewModel){
        viewModel.addAttribute("welcomeMessage", "Welcome to " + cohort + "!");
        return "join";
    }

}