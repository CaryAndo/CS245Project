package games;

/**
 * Created by cary on 1/15/16.
 */
public class GameResults {

    private boolean mDidWin = false;

    public GameResults() {

    }

    public void setDidWin(boolean didWin) {
        this.mDidWin = didWin;
    }

    public boolean didWin() {
        return this.mDidWin;
    }
}
