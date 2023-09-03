package com.example.lab1;

import com.example.lab1.GameState;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {

    private String lettersUsed = "";
    private String underscoreWord;
    private String wordToGuess;
    private final int maxTries = 7;
    private int currentTries = 0;
    private int drawable = R.drawable.game0;

    public GameState startNewGame() {
        lettersUsed = "";
        currentTries = 0;
        drawable = R.drawable.game7;
        int randomIndex = new Random().nextInt(GameContants.words.size());
        wordToGuess = GameContants.words.get(randomIndex);
        generateUnderscores(wordToGuess);
        return getGameState();
    }

    public void generateUnderscores(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == '/') {
                sb.append('/');
            } else {
                sb.append("_");
            }
        }
        underscoreWord = sb.toString();
    }

    public GameState play(char letter) {
        if (lettersUsed.contains(String.valueOf(letter))) {
            return new GameState.Running(lettersUsed, underscoreWord, drawable);
        }

        lettersUsed += letter;
        List<Integer> indexes = new ArrayList<>();

        for (int index = 0; index < wordToGuess.length(); index++) {
            char c = wordToGuess.charAt(index);
            if (Character.toLowerCase(c) == Character.toLowerCase(letter)) {
                indexes.add(index);
            }
        }

        String finalUnderscoreWord = underscoreWord;
        for (int index : indexes) {
            StringBuilder sb = new StringBuilder(finalUnderscoreWord);
            sb.setCharAt(index, letter);
            finalUnderscoreWord = sb.toString();
        }

        if (indexes.isEmpty()) {
            currentTries++;
        }

        underscoreWord = finalUnderscoreWord;
        return getGameState();
    }

    private int getHangmanDrawable() {
        switch (currentTries) {
            case 0:
                return R.drawable.game0;
            case 1:
                return R.drawable.game1;
            case 2:
                return R.drawable.game2;
            case 3:
                return R.drawable.game3;
            case 4:
                return R.drawable.game4;
            case 5:
                return R.drawable.game5;
            case 6:
                return R.drawable.game6;
            case 7:
                return R.drawable.game7;
            default:
                return R.drawable.game7;
        }
    }

    private GameState getGameState() {
        if (underscoreWord.equalsIgnoreCase(wordToGuess)) {
            return new GameState.Won(wordToGuess);
        }

        if (currentTries == maxTries) {
            return new GameState.Lost(wordToGuess);
        }

        drawable = getHangmanDrawable();
        return new GameState.Running(lettersUsed, underscoreWord, drawable);
    }
}