package com.codeup.codeup_demo.springblog.controllers;//package com.codeup.codeup_demo.springblog.controllers;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//@Controller
//class HelloController {
//
//@GetMapping("/hello")
//@ResponseBody
//public String hello() {
//        return "Hello from Spring!";
//        }
////
////    @GetMapping("/hello/{name}")
////    @ResponseBody
////    public String sayHello(@PathVariable String name) {
////        return "Hello " + name + "!";
////    }
////
////    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
////    @ResponseBody
////    public String addOne(@PathVariable int number) {
////        return number + " plus one is " + (number + 1) + "!";
////    }
////
////    @RequestMapping(path = "/subtract/{number}", method = RequestMethod.GET)
////    @ResponseBody
////    public String substractOne(@PathVariable int number) {
////        return number + " minus one is " + (number - 1) + "!";
////    }
////
////    @RequestMapping(path = "/multiply/{number}", method = RequestMethod.GET)
////    @ResponseBody
////    public String multiply(@PathVariable int number) {
////        return number + (number * number) + "!";
////    }
//
//    @GetMapping("/hello/{name}")
//    public String sayHello(@PathVariable String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
//
//    @GetMapping("/join")
//    public String renderForm() {
//        return "join";
//    }
//
//@PostMapping("/join")
//    public String submitForm(@RequestParam(name = "cohort")String cohort, Model viewModel) {
//        viewModel.addAttribute("welcomeMessage", "Welcome to " + cohort + "!");
//        return "join";
//
//}
//}

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("/home")
//    @ResponseBody
//    public String hello() {
//        return "Welcome!";
//    }

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
    public String renderForm() {
        return "join";
    }

    @PostMapping("/join")
    public String submitForm(
            @RequestParam(name = "cohort") String cohort,
            Model viewModel) {
        viewModel.addAttribute("welcomeMessage", "Welcome to " + cohort + "!");
        return "join";
    }

}