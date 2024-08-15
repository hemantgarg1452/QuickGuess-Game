package com.project.GuessTheWord.Controllers;

import com.project.GuessTheWord.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/home")
    public String home(Model model){

        String randomWord = gameService.getRandomWord();
        model.addAttribute("WordToDisplay", randomWord);

        return "Home";
    }
}
