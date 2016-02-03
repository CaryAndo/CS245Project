package GUI.bubble;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 2/3/16.
 */
public class BubblePanel extends JPanel {

    Color mColor;

    public BubblePanel(Color color) {
        this.mColor = color;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(mColor);
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
