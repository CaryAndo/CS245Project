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
        sColorMap.put(Color.ORANGE, "Orange");
        sColorMap.put(Color.PINK, "Pink");
        sColorMap.put(Color.WHITE, "White");
        sColorMap.put(Color.BLACK, "Black");
    }

    private Color mColor;
    private boolean mIsRoundOver = false;

    public BubbleClickGameRound() {

        Color[] colors = {
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.ORANGE,
                Color.PINK,
                Color.WHITE,
                Color.BLACK
        };

        mColor = colors[ThreadLocalRandom.current().nextInt(0, colors.length-1)]; // Pick a random color
    }

    public void attemptColor(Color color) {
        if (color.equals(mColor)) {
            mPoints += 100;
        }

        mIsRoundOver = true;
    }

    public int getPoints() {
        return mPoints;
    }

    public boolean isRoundOver() {
        return mIsRoundOver;
    }

    public Color getColor() {
        return mColor;
    }

}
