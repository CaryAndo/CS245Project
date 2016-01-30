package games;

/**
 * Created by cary on 1/15/16.
 */
/***************************************************************
 * file: GameResults.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: Multi-purpose POJO to hold details about a game that was played
 *
 ****************************************************************/
public class GameResults {

    private boolean mDidFinish = false;
    private boolean mDidWin = false;
    private int mPoints = 0;
    private int mIncorrectGuesses = 0;

    public GameResults() {

    }

    public GameResults(boolean didWin, int points, int incorrectGuesses, boolean didFinish) {
        this.mDidWin = didWin;
        this.mPoints = points;
        this.mIncorrectGuesses = incorrectGuesses;
        this.mDidFinish = didFinish;
    }

    public void setDidWin(boolean didWin) {
        this.mDidWin = didWin;
    }

    public boolean didWin() {
        return this.mDidWin;
    }

    public void setPoints(int points) {
        this.mPoints = points;
    }

    public int getPoints() {
        return this.mPoints;
    }

    public void setIncorrectGuesses(int guesses) {
        this.mIncorrectGuesses = guesses;
    }

    public int getIncorrectGuesses() {
        return this.mIncorrectGuesses;
    }

    public void setDidFinish(boolean didFinish) {
        this.mDidFinish = didFinish;
    }

    public boolean didFinish() {
        return this.mDidFinish;
    }
}
