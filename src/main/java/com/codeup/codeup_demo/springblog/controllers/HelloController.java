package com.codeup.codeup_demo.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @RequestMapping(path = "/subtract/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String substractOne(@PathVariable int number) {
        return number + " minus one is " + (number - 1) + "!";
    }

    @RequestMapping(path = "/multiply/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number) {
        return number + (number * number) + "!";
    }
}