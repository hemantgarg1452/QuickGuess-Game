package com.project.GuessTheWord.Services;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {

    private String[] randomWords = {"Java", "twitter", "Game", "meta", "apartment", "flight", "japan"};
    private Random random = new Random();


    public String getRandomWord() {
        return randomWords[random.nextInt(randomWords.length)];
    }
}
