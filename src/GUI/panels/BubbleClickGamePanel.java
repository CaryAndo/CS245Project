package GUI.panels;

import GUI.bubble.BubblePanel;
import callbacks.BubbleClickCallbacks;
import callbacks.NavigationCallbacks;
import games.BubbleClickGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 2/3/16.
 */
public class BubbleClickGamePanel extends JPanel implements BubbleClickCallbacks {

    private NavigationCallbacks mCallbacks;
    private BubbleClickGame mGame;

    public BubbleClickGamePanel(NavigationCallbacks callbacks) {
        this.mCallbacks = callbacks;
        this.mGame = new BubbleClickGame();

        initUI();
    }

    @Override
    public void click(Color color) {
        mGame.attemptColor(color);

        if (mGame.isGameOver()) {
            mCallbacks.startFinishScreen(mGame.getGameResults());
        }
    }

    private void initUI() {
        BubblePanel panel = new BubblePanel(Color.RED);
        add(panel);
    }
}
