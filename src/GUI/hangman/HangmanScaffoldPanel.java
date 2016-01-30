package GUI.hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/***************************************************************
 * file: HangmanScaffoldPanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: This is the panel upon which the Scaffold is drawn
 * and upon which we display most of the feedback for a game of
 * hangman
 *
 ****************************************************************/
public class HangmanScaffoldPanel extends JPanel {

    private boolean mDrawHead = false;
    private boolean mDrawBody = false;
    private boolean mDrawLeftArm = false;
    private boolean mDrawRightArm = false;
    private boolean mDrawRightLeg = false;
    private boolean mDrawLeftLeg = false;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String currentDateString = dateFormat.format(Calendar.getInstance().getTime());
    private boolean mWinner = false;

    public boolean isDrawingRightLeg() {
        return mDrawRightLeg;
    }

    public void setDrawRightLeg(boolean mDrawRightLeg) {
        this.mDrawRightLeg = mDrawRightLeg;
    }

    public boolean isDrawingHead() {
        return mDrawHead;
    }

    public void setDrawHead(boolean mDrawHead) {
        this.mDrawHead = mDrawHead;
    }

    public boolean isDrawingBody() {
        return mDrawBody;
    }

    public void setDrawBody(boolean mDrawBody) {
        this.mDrawBody = mDrawBody;
    }

    public boolean isDrawingLeftArm() {
        return mDrawLeftArm;
    }

    public void setDrawLeftArm(boolean mDrawLeftArm) {
        this.mDrawLeftArm = mDrawLeftArm;
    }

    public boolean isDrawingRightArm() {
        return mDrawRightArm;
    }

    public void setDrawRightArm(boolean mDrawRightArm) {
        this.mDrawRightArm = mDrawRightArm;
    }

    public boolean isDrawingLeftLeg() {
        return mDrawLeftLeg;
    }

    public void setDrawLeftLeg(boolean mDrawLeftLeg) {
        this.mDrawLeftLeg = mDrawLeftLeg;
    }

    public void setWinner(boolean winner) {
        mWinner = winner;
    }

    public void addNextBodyPart() {
        if (!isDrawingHead()) {
            setDrawHead(true);
        } else if (!isDrawingBody()) {
            setDrawBody(true);
        } else if (!isDrawingRightArm()) {
            setDrawRightArm(true);
        } else if (!isDrawingLeftArm()) {
            setDrawLeftArm(true);
        } else if (!isDrawingRightLeg()) {
            setDrawRightLeg(true);
        } else if (!isDrawingLeftLeg()) {
            setDrawLeftLeg(true);
        }

        repaint();
    }

    public HangmanScaffoldPanel() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDateString = dateFormat.format(Calendar.getInstance().getTime());
                repaint();
            }
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        /**
         * Drawing constants
         * */
        final int LINE_THICKNESS = 5;
        final int SCAFFOLD_TOP_MARGIN = 10;
        final int MAN_WIDTH = 200;
        final int TIDBIT_HEIGHT = 10;
        final int MAN_HEAD_DIAMETER = 30;
        final int MAN_BODY_HEIGHT = 50;
        final int SHOULDER_SPACE = 10;
        final int MAN_ARM_WIDTH = 30;
        final int MAN_ARM_HEIGHT = 15;
        final int MAN_LEG_WIDTH = 15;
        final int MAN_LEG_HEIGHT = 15;

        int poleXPosition = getWidth()/3 - LINE_THICKNESS;
        int manXPosition = getWidth()/3 - LINE_THICKNESS/2 + (MAN_WIDTH/2) - MAN_HEAD_DIAMETER/2;

        int manYTopOfHead = SCAFFOLD_TOP_MARGIN + LINE_THICKNESS/2 + TIDBIT_HEIGHT;
        int manYBottomOfHead = manYTopOfHead + MAN_HEAD_DIAMETER;
        int manYBottomofTorso = manYTopOfHead + MAN_HEAD_DIAMETER + MAN_BODY_HEIGHT;

        /**
         * Start actually drawing
         * */
        g.fillRect(0, getHeight() - LINE_THICKNESS, getWidth(), LINE_THICKNESS); // Draw the bottom of the scaffold
        g.fillRect(poleXPosition, SCAFFOLD_TOP_MARGIN, LINE_THICKNESS, getHeight() - LINE_THICKNESS); // Draw the scaffold poll
        g.fillRect(poleXPosition, SCAFFOLD_TOP_MARGIN, MAN_WIDTH/2, LINE_THICKNESS); // Draw the scaffold overhang
        g.fillRect(poleXPosition + (MAN_WIDTH/2), SCAFFOLD_TOP_MARGIN, LINE_THICKNESS, TIDBIT_HEIGHT); // Draw the little scaffold overhang nub

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));

        g2.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        g2.drawString("Hangman!", 5, 50);

        if (mDrawHead) {
            g2.drawOval(
                    getWidth() / 3 - LINE_THICKNESS / 2 + (MAN_WIDTH / 2) - MAN_HEAD_DIAMETER / 2,
                    SCAFFOLD_TOP_MARGIN + LINE_THICKNESS / 2 + TIDBIT_HEIGHT,
                    MAN_HEAD_DIAMETER,
                    MAN_HEAD_DIAMETER
            ); // Draw the man's head
        }

        if (mDrawBody) {
            g2.drawLine(
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYTopOfHead + MAN_HEAD_DIAMETER,
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYBottomofTorso
            ); // Draw the man's body
        }

        if (mDrawRightArm) {
            g2.drawLine(
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYBottomOfHead + SHOULDER_SPACE,
                    manXPosition + (MAN_HEAD_DIAMETER / 2 + 30),
                    manYBottomOfHead + SHOULDER_SPACE - MAN_ARM_HEIGHT
            ); // Draw the man's right arm
        }

        if (mDrawLeftArm) {
            g2.drawLine(
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYBottomOfHead + SHOULDER_SPACE,
                    manXPosition - MAN_HEAD_DIAMETER / 2,
                    manYBottomOfHead + SHOULDER_SPACE - MAN_ARM_HEIGHT
            ); // Draw the man's left arm
        }

        if (mDrawRightLeg) {
            g2.drawLine(
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYBottomofTorso,
                    manXPosition + MAN_HEAD_DIAMETER / 2 + MAN_LEG_WIDTH,
                    manYBottomofTorso + MAN_LEG_HEIGHT
            ); // Draw the man's right leg
        }
        
        if (mDrawLeftLeg) {
            g2.drawLine(
                    manXPosition + MAN_HEAD_DIAMETER / 2,
                    manYBottomofTorso,
                    manXPosition + MAN_HEAD_DIAMETER / 2 - MAN_LEG_WIDTH,
                    manYBottomofTorso + MAN_LEG_HEIGHT
            ); // Draw the man's left leg

            g2.setColor(Color.RED);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 60));
            g2.drawString("WASTED", 25, manYBottomofTorso);
        }

        if (mWinner) {
            g2.setColor(Color.GREEN);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 60));
            g2.drawString("WINNER", 25, manYBottomofTorso);
        }

        g2.setFont(UIManager.getDefaults().getFont("TabbedPane.font")); // Set the font back to default
        g2.setColor(Color.BLACK);
        g2.drawString(currentDateString, getWidth() - 150, 20);
    }
}
