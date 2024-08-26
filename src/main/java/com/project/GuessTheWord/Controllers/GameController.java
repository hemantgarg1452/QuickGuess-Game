package com.project.GuessTheWord.Controllers;

import com.project.GuessTheWord.Services.GameService;
import com.project.GuessTheWord.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/home")
    public String home(@RequestParam(value = "GuessWord", required = false) String GuessWord, Model model){
        System.out.println("Captured char is : " + GuessWord);

        // Fetch the word to display (with guessed characters)
        String randomWord = gameService.getRandomWord();

        if (GuessWord != null && !GuessWord.isEmpty()) {
            // Add guessed word and check if it was correct
            boolean isCorrect = GameService.addGuessedWord(GuessWord.charAt(0));
            randomWord = gameService.getRandomWord(); // Update displayed word with guessed character(s)

            // If guess was incorrect, reduce tries
            if (isCorrect==false) {
                gameUtils.reduceTry();
            }
        }

        // Output remaining tries to console for debugging
        System.out.println("Remaining tries are : " + gameUtils.getRemainingTries());

        model.addAttribute("WordToDisplay", randomWord);
        model.addAttribute("RemainingTries", gameUtils.getRemainingTries());
        return "Home";
    }
}