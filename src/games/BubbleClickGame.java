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

    public boolean isGameOver() {
        return mIsGameOver;
    }

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

        Color[] potentialColors = {
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.ORANGE,
                Color.PINK,
                Color.WHITE,
                Color.BLACK
        };

        /**
         *
         * */
        for (Color potentialColor : potentialColors) {
            if (!potentialColor.equals(getCurrentColor())) {
                tempColorList.add(potentialColor);
            }
        }

        /**
         * Add spurious colors
         * */
        for (int i = 0; i < 4; i++) {
            int tempIndex = ThreadLocalRandom.current().nextInt(0, tempColorList.size()-1);
            colorList.add(tempColorList.get(tempIndex));
            tempColorList.remove(tempIndex);
        }

        /**
         * Insert the actual color into a random array position
         * */
        colorList.add(ThreadLocalRandom.current().nextInt(0, colorList.size()-1), getCurrentColor());

        return colorList;
    }

    public Color getCurrentColor() {
        return mRounds[mCurrentBubbleClickGameRound].getColor();
    }

    public GameResults getGameResults() {
        GameResults results = new GameResults();
        results.setDidFinish(mIsGameOver);
        results.setPoints(getPoints());
        return results;
    }
}
