package GUI.bubble;

import callbacks.BubbleClickCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by cary on 2/3/16.
 */
public class BubblePanel extends JPanel {

    //Color mColor = Color.RED; // Arbitrary default color
    private Color mColor = new Color(200, 0, 0); // Arbitrary default color
    private Color mColorHighlight;
    private boolean mIsHighlighted = false;
    private BubbleClickCallbacks mCallbacks;

    public BubblePanel(BubbleClickCallbacks callbacks) {
        this.mCallbacks = callbacks;
        setOpaque(false);

        int newRed = mColor.getRed();
        int newGreen = mColor.getGreen();
        int newBlue = mColor.getBlue();

        if (!(newRed + 30 > 255)) {
            newRed += 30;
        }

        if (!(newGreen + 30 > 255)) {
            newGreen += 30;
        }

        if (!(newBlue + 30 > 255)) {
            newBlue += 30;
        }

        mColorHighlight = new Color(newRed, newGreen, newBlue);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mCallbacks.click(mColor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mIsHighlighted = true;

                //System.out.println("Bubble Color: " + mColor);
                //System.out.println("Highlight Color" + mColorHighlight);

                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mIsHighlighted = false;

                //System.out.println("Bubble Color: " + mColor);
                //System.out.println("Highlight Color" + mColorHighlight);

                repaint();
            }
        });
    }

    public void setColor(Color color) {
        this.mColor = color;

        int newRed = mColor.getRed();
        int newGreen = mColor.getGreen();
        int newBlue = mColor.getBlue();

        if (!(newRed + 30 > 255)) {
            newRed += 30;
        }

        if (!(newGreen + 30 > 255)) {
            newGreen += 30;
        }

        if (!(newBlue + 30 > 255)) {
            newBlue += 30;
        }

        mColorHighlight = new Color(newRed, newGreen, newBlue);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (mIsHighlighted) {
            g.setColor(mColorHighlight);
        } else {
            g.setColor(mColor);
        }

        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
