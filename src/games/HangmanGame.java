package games;

import GUI.hangman.HangmanScaffoldPanel;
import GUI.hangman.HangmanWordPanel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/***************************************************************
 * file: HangmanGame.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: Represents a game of Hangman being played
 * It should be responsible for maintaining
 * game state and providing an interface to play
 *
 ****************************************************************/
public class HangmanGame {

    private boolean mIsGameOver = false;
    private boolean mDidWin = false;
    private int mPoints = 100;
    private int mIncorrectGuesses = 0;
    private String mWord = "";
    private Set<Character> attemptedLetters = new HashSet<>();

    private HangmanWordPanel mWordPanel;
    private HangmanScaffoldPanel mScaffoldPanel;

    public HangmanGame(String word, HangmanWordPanel wordPanel, HangmanScaffoldPanel scaffoldPanel) {
        this.mWord = word.toUpperCase();
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
        mIncorrectGuesses++;
        mPoints -= 10;

        /*if (mPoints <= 0) {
            mIsGameOver = true;
        }*/

        calculateGameState();

        return false;
    }

    public boolean isGameOver() {
        calculateGameState();
        return mIsGameOver;
    }

    public GameResults getGameResults() {
        GameResults results = new GameResults();
        results.setDidFinish(mIsGameOver);
        results.setDidWin(mDidWin);
        results.setIncorrectGuesses(mIncorrectGuesses);
        if (mIsGameOver) {
            results.setPoints(mPoints);
        } else {
            results.setPoints(0); // Game was skipped, give the user 0 points
        }

        return results;
    }

    private void calculateGameState() {
        boolean triedAllLetters = true;
        for (int i = 0; i < mWord.length(); i++) {
            if (!attemptedLetters.contains(mWord.charAt(i))) {
                triedAllLetters = false;
                break;
            }
        }

        if (triedAllLetters) {
            mIsGameOver = true;
            if (mIncorrectGuesses < 6) {
                mDidWin = true;
                mScaffoldPanel.setWinner(true);
                mScaffoldPanel.repaint();
            } else {
                mDidWin = false;
            }
        } else if (mIncorrectGuesses >= 6 || mPoints <= 40) {
            mIsGameOver = true;
            mDidWin = false;
        }
    }
}
