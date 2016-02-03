package games;

import java.awt.*;

/**
 * Created by cary on 2/3/16.
 */
public class BubbleClickGame {

    private boolean mIsGameOver = false;
    private BubbleClickGameRound[] mRounds = new BubbleClickGameRound[5];
    private int mCurrentBubbleClickGameRound = 0;

    public BubbleClickGame() {

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
