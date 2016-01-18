package games;

import GUI.hangman.HangmanScaffoldPanel;
import GUI.hangman.HangmanWordPanel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a game of Hangman being played
 * It should be responsible for maintaining
 * game state and providing an interface to play
 *
 * Created by cary on 1/13/16.
 */
public class HangmanGame {

    private boolean mIsGameOver = false;
    private int mPoints = 100;
    private String mWord = "";
    private Set<Character> attemptedLetters = new HashSet<>();
    private GameResults mResults = null;
    private char[] successfulLetters;

    private HangmanWordPanel mWordPanel;
    private HangmanScaffoldPanel mScaffoldPanel;

    public HangmanGame(String word, HangmanWordPanel wordPanel, HangmanScaffoldPanel scaffoldPanel) {
        this.mWord = word.toUpperCase();
        this.successfulLetters = new char[mWord.length()];
        this.mWordPanel = wordPanel;

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < mWord.length(); i++) {
            temp.append(" ");
        }

        this.mWordPanel.setLetters(temp.toString().toCharArray());
        this.mScaffoldPanel = scaffoldPanel;
    }

    /**
     * Return a list of all the indices where
     * */
    public List<Integer> indices(String string, char character) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                indices.add(i);
            }
        }

        return indices;
    }

    public boolean attemptLetter(char letter) {
        if (mIsGameOver) {
            return false;
        }

        if (mWord.contains(Character.toString(letter))) {
            if (!attemptedLetters.contains(letter)) {
                attemptedLetters.add(letter);
                for (int i : indices(mWord, letter)) {
                    try {
                        mWordPanel.addLetter(i, letter);
                    } catch (Exception e) {
                        System.out.println("Something went horribly wrong");
                    }
                }
            }

            return true;
        }

        attemptedLetters.add(letter);
        mScaffoldPanel.addNextBodyPart();

        if (mPoints <= 0) {
            mIsGameOver = true;
        }

        return false;
    }

    public boolean isGameOver() {
        return mIsGameOver;
    }

    public GameResults getGameResults() {
        return new GameResults();
    }

    private void calculateGameState() {
        boolean triedAllLetters = false;
        for (int i = 0; i < mWord.length(); i++) {
            if (!attemptedLetters.contains(mWord.charAt(i))) {
                triedAllLetters = true;
                break;
            }
        }

        if (triedAllLetters) {
            if (mPoints > 0) {
                // we won
                mIsGameOver = true;
            } else {
                // we lose
            }
        }

    }
}
