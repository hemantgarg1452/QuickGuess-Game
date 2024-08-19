package com.project.GuessTheWord.Services;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {
    private String randomChoosen = null;
    private String[] randomWords = {"Java", "twitter", "Game", "meta", "apartment", "flight", "japan"};
    private char[] allCharacters;
    private Random random = new Random();


    public GameService() {
        randomChoosen = randomWords[random.nextInt(randomWords.length)];
        System.out.println("random word is: "+ randomChoosen);
        allCharacters = new char[randomChoosen.length()];
    }

    public String getRandomWord() {
        String blank = "";

        for (char ch : allCharacters){
            if(ch=='\u0000') blank+="__";

            blank+=' ';
        }
        return blank;

    }
}
