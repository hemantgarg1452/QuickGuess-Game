package com.project.GuessTheWord.utils;

import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    private int MAX_TRIES = 5;

    public int reduceTry(){
        if (MAX_TRIES > 0) {
            MAX_TRIES--;
        }
        return MAX_TRIES;
    }

    public int getRemainingTries(){
        return MAX_TRIES;
    }
}