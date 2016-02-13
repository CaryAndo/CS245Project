/***************************************************************
 * file: BubbleClickGameRound.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 02/11/2016
 *
 * purpose: This is where the current game round is initialized 
 *          and the colors randomly determined
 *
 ****************************************************************/

package games;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cary on 2/3/16.
 */
public class BubbleClickGameRound {

    private static Map<Color, String> sColorMap = new HashMap<>();
    private int mPoints = 0;

    static {
        sColorMap.put(Color.RED, "Red");
        sColorMap.put(Color.GREEN, "Green");
        sColorMap.put(Color.BLUE, "Blue");
        sColorMap.put(Color.YELLOW, "Yellow");
        sColorMap.put(Color.MAGENTA, "Purple");
    }

    private Color mColor;
    private boolean mIsRoundOver = false;

    public BubbleClickGameRound() {

        Color[] colors = {
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.MAGENTA
        };

        mColor = colors[ThreadLocalRandom.current().nextInt(0, colors.length-1)]; // Pick a random color
    }
    //if correct color is selected, add 100 points and go to next round
    public void attemptColor(Color color) {
        if (color.equals(mColor)) {
            mPoints += 100;
        }

        mIsRoundOver = true;
    }
    //returns the amount of points
    public int getPoints() {
        return mPoints;
    }
    //returns status of round 
    public boolean isRoundOver() {
        return mIsRoundOver;
    }
    //returns the color
    public Color getColor() {
        return mColor;
    }
    //returns the texts color name
    public String getColorName() {
        return sColorMap.get(mColor);
    }
    //returns the final score message
    public String toString() {
        return "Points: " + mPoints + " Color: " + mColor;
    }
    //returns the color
    public static String getColorName(Color color) {
        return sColorMap.get(color);
    }
}
