package com.project.GuessTheWord.Controllers;

import com.project.GuessTheWord.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/home")
    public String home(@RequestParam(value = "GuessWord", required = false) String GuessWord, Model model){
        System.out.println("Captured char is : " + GuessWord);

        String randomWord = gameService.getRandomWord();

        if(GuessWord!=null){
            GameService.addGuessedWord(GuessWord.charAt(0));
            randomWord = gameService.getRandomWord();
        }

        model.addAttribute("WordToDisplay", randomWord);

        return "Home";
    }
}
