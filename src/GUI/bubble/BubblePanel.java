package GUI.bubble;

import callbacks.BubbleClickCallbacks;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 2/3/16.
 */
public class BubblePanel extends JPanel {

    Color mColor = Color.RED; // Arbitrary default color
    BubbleClickCallbacks mCallbacks;

    public BubblePanel(BubbleClickCallbacks callbacks) {
        this.mCallbacks = callbacks;
        setOpaque(false);
    }

    public void setColor(Color color) {
        this.mColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(mColor);
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
