/***************************************************************
 * file: BubblePanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 02/12/2016
 *
 * purpose: This class defines the characteristics of the 
 *          bubble panels and bubbles in the bubble click game
 *
 ****************************************************************/

package GUI.bubble;

import callbacks.BubbleClickCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BubblePanel extends JPanel {

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

        if (!(newRed + 100 > 255)) {
            newRed += 100;
        }

        if (!(newGreen + 100 > 255)) {
            newGreen += 100;
        }

        if (!(newBlue + 100 > 255)) {
            newBlue += 100;
        }

        mColorHighlight = new Color(newRed, newGreen, newBlue);
        
        //for mouse event detection such as clicks, hover, and exits
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

                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                mIsHighlighted = false;

                repaint();
            }
        });
    }
    //sets the colors of the bubble and defines
    //the highlighting of the bubbles upon mouse hover
    public void setColor(Color color) {
        this.mColor = color;

        int newRed = mColor.getRed();
        int newGreen = mColor.getGreen();
        int newBlue = mColor.getBlue();

        if (!(newRed + 100 > 255)) {
            newRed += 100;
        }

        if (!(newGreen + 100 > 255)) {
            newGreen += 100;
        }

        if (!(newBlue + 100 > 255)) {
            newBlue += 100;
        }

        mColorHighlight = new Color(newRed, newGreen, newBlue);

        repaint();
    }
    //redraws the bubble panel with the new intensity of color
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
