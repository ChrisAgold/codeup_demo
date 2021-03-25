package com.codeup.codeup_demo.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice/{guess}")
    @ResponseBody
    public String showRollDicePage(@PathVariable int guess, Model viewModel) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6+1);
        viewModel.addAttribute("isCorrect", randomNum == guess);
        return "roll-dice";
    }

}