package com.project.GuessTheWord.Services;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class GameService {
    private static String randomChoosen = null;
    private String[] randomWords = {"Java", "twitter", "Game", "meta", "apartment", "flight", "japan"};
    private static char[] allCharacters;
    private Random random = new Random();


    public GameService() {
        randomChoosen = randomWords[random.nextInt(randomWords.length)];
        System.out.println("random word is: "+ randomChoosen);
        allCharacters = new char[randomChoosen.length()];
    }

    public static void addGuessedWord(char GuessWord) {
        for(int i=0; i<randomChoosen.length(); i++){
            if(GuessWord == randomChoosen.charAt(i)){
                allCharacters[i] = GuessWord;
            }
        }
    }

    public String getRandomWord() {
        String blank = "";

        for (char ch : allCharacters){
            if(ch=='\u0000') {
                blank += "__";
            }
            else {
                blank += ch;
            }
            blank+=' ';
        }
        return blank;

    }
}
