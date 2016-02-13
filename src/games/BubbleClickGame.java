/***************************************************************
 * file: BubbleClickGame.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 02/11/2016
 *
 * purpose: This is where all the logic of the state of 
 *          the bubble click game is updated and stored
 *
 ****************************************************************/

package games;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cary on 2/3/16.
 */
public class BubbleClickGame {

    private boolean mIsGameOver = false;
    private BubbleClickGameRound[] mRounds = new BubbleClickGameRound[5];
    private int mCurrentBubbleClickGameRound = 0;

    public BubbleClickGame() {
        for (int i = 0; i < mRounds.length; i++) {
            mRounds[i] = new BubbleClickGameRound();
        }
    }

    /**
     * User clicked on a color
     * */
    public void attemptColor(Color attemptedColor) {
        if (mIsGameOver) {
            return;
        }

        BubbleClickGameRound currentRound = mRounds[mCurrentBubbleClickGameRound];
        currentRound.attemptColor(attemptedColor);

        if (mCurrentBubbleClickGameRound == mRounds.length - 1) {
            mIsGameOver = true;
        } else {
            mCurrentBubbleClickGameRound++;
        }
    }
    //returns status of game over
    public boolean isGameOver() {
        return mIsGameOver;
    }
    //returns the points that the user has
    public int getPoints() {
        int points = 0;

        for (BubbleClickGameRound mRound : mRounds) {
            points += mRound.getPoints();
        }

        return points;
    }

    /**
     * Get colors to fill in the GUI bubbles
     * */
    public ArrayList<Color> getColors() {
        ArrayList<Color> colorList = new ArrayList<>();
        ArrayList<Color> tempColorList = new ArrayList<>();

        //System.out.println("Generating new list of random colors");

        Color[] potentialColors = {
            
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.MAGENTA
        };

        /**
         * Add Colors that are not the special color to a temporary list
         * */
        for (Color potentialColor : potentialColors) {
            if (!potentialColor.equals(getCurrentColor())) {
                tempColorList.add(potentialColor);   
            }
        }

        /**
         * Add spurious colors from the temporary list to the final list
         * */
        for (int i = 0; i < 4; i++) {
            int tempIndex = ThreadLocalRandom.current().nextInt(0, tempColorList.size());
            colorList.add(tempColorList.get(tempIndex));
            tempColorList.remove(tempIndex);
        }

        /**
         * Insert the actual color into a random array position
         * */
        int correctIndex = ThreadLocalRandom.current().nextInt(0, colorList.size());
        colorList.add(correctIndex, getCurrentColor());
        //System.out.println("Correct color is at position: " + correctIndex + " out of " + colorList.size());

        return colorList;
    }
    //returns the current color
    public Color getCurrentColor() {
        return mRounds[mCurrentBubbleClickGameRound].getColor();
    }
    //returns the results of the game
    public GameResults getGameResults() {
        GameResults results = new GameResults();
        results.setDidFinish(mIsGameOver);
        results.setPoints(getPoints());
        return results;
    }
    //returns the name of the color
    public String getCurrentColorString() {
        return mRounds[mCurrentBubbleClickGameRound].getColorName();
    }
}
