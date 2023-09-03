package com.example.lab1;



public abstract class GameState {

    public static class Running extends GameState {
        public String lettersUsed;
        public String underscoreWord;
        public int drawable;

        public Running(String lettersUsed, String underscoreWord, int drawable) {
            this.lettersUsed = lettersUsed;
            this.underscoreWord = underscoreWord;
            this.drawable = drawable;
        }
    }

    public static class Lost extends GameState {
        public String wordToGuess;

        public Lost(String wordToGuess) {
            this.wordToGuess = wordToGuess;
        }
    }

    public static class Won extends GameState {
        public String wordToGuess;

        public Won(String wordToGuess) {
            this.wordToGuess = wordToGuess;
        }
    }
}
