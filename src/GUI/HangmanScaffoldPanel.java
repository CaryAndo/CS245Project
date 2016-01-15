package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 1/15/16.
 */
public class HangmanScaffoldPanel extends JPanel {

    private static final int LINE_THICKNESS = 5;
    private static final int SCAFFOLD_TOP_MARGIN = 10;
    private static final int MAN_WIDTH = 200;
    private static final int TIDBIT_HEIGHT = 10;
    private static final int MAN_HEAD_DIAMETER = 30;
    private static final int MAN_BODY_HEIGHT = 50;
    private static final int SHOULDER_SPACE = 10;
    private static final int MAN_ARM_WIDTH = 30;
    private static final int MAN_ARM_HEIGHT = 15;
    private static final int MAN_LEG_WIDTH = 15;
    private static final int MAN_LEG_HEIGHT = 15;

    private boolean mDrawHead = false;
    private boolean mDrawBody = false;
    private boolean mDrawLeftArm = false;
    private boolean mDrawRightArm = false;
    private boolean mDrawRightLeg = false;
    private boolean mDrawLeftLeg = false;

    public boolean ismDrawRightLeg() {
        return mDrawRightLeg;
    }

    public void setmDrawRightLeg(boolean mDrawRightLeg) {
        this.mDrawRightLeg = mDrawRightLeg;
    }

    public boolean ismDrawHead() {
        return mDrawHead;
    }

    public void setmDrawHead(boolean mDrawHead) {
        this.mDrawHead = mDrawHead;
    }

    public boolean ismDrawBody() {
        return mDrawBody;
    }

    public void setmDrawBody(boolean mDrawBody) {
        this.mDrawBody = mDrawBody;
    }

    public boolean ismDrawLeftArm() {
        return mDrawLeftArm;
    }

    public void setmDrawLeftArm(boolean mDrawLeftArm) {
        this.mDrawLeftArm = mDrawLeftArm;
    }

    public boolean ismDrawRightArm() {
        return mDrawRightArm;
    }

    public void setmDrawRightArm(boolean mDrawRightArm) {
        this.mDrawRightArm = mDrawRightArm;
    }

    public boolean ismDrawLeftLeg() {
        return mDrawLeftLeg;
    }

    public void setmDrawLeftLeg(boolean mDrawLeftLeg) {
        this.mDrawLeftLeg = mDrawLeftLeg;
    }


    public HangmanScaffoldPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        int poleXPosition = getWidth()/3 - LINE_THICKNESS;
        int manXPosition = getWidth()/3 - LINE_THICKNESS/2 + (MAN_WIDTH/2) - MAN_HEAD_DIAMETER/2;

        int manYTopOfHead = SCAFFOLD_TOP_MARGIN + LINE_THICKNESS/2 + TIDBIT_HEIGHT;
        int manYBottomOfHead = manYTopOfHead + MAN_HEAD_DIAMETER;
        int manYBottomofTorso = manYTopOfHead + MAN_HEAD_DIAMETER + MAN_BODY_HEIGHT;

        g.fillRect(0, getHeight() - LINE_THICKNESS, getWidth(), LINE_THICKNESS); // Draw the bottom of the scaffold
        g.fillRect(poleXPosition, SCAFFOLD_TOP_MARGIN, LINE_THICKNESS, getHeight() - LINE_THICKNESS); // Draw the scaffold poll
        g.fillRect(poleXPosition, SCAFFOLD_TOP_MARGIN, MAN_WIDTH/2, LINE_THICKNESS); // Draw the scaffold overhang
        g.fillRect(poleXPosition + (MAN_WIDTH/2), SCAFFOLD_TOP_MARGIN, LINE_THICKNESS, TIDBIT_HEIGHT); // Draw the little scaffold overhang nub

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawOval(
                getWidth()/3 - LINE_THICKNESS/2 + (MAN_WIDTH/2) - MAN_HEAD_DIAMETER/2,
                SCAFFOLD_TOP_MARGIN + LINE_THICKNESS/2 + TIDBIT_HEIGHT,
                MAN_HEAD_DIAMETER,
                MAN_HEAD_DIAMETER
        ); // Draw the man's head
        g2.drawLine(
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYTopOfHead + MAN_HEAD_DIAMETER,
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYBottomofTorso
        ); // Draw the man's body
        g2.drawLine(
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYBottomOfHead + SHOULDER_SPACE,
                manXPosition + (MAN_HEAD_DIAMETER/2 + 30),
                manYBottomOfHead + SHOULDER_SPACE - MAN_ARM_HEIGHT
        ); // Draw the man's right arm
        g2.drawLine(
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYBottomOfHead + SHOULDER_SPACE,
                manXPosition - MAN_HEAD_DIAMETER/2,
                manYBottomOfHead + SHOULDER_SPACE - MAN_ARM_HEIGHT
        ); // Draw the man's left arm
        g2.drawLine(
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYBottomofTorso,
                manXPosition + MAN_HEAD_DIAMETER/2 + MAN_LEG_WIDTH,
                manYBottomofTorso + MAN_LEG_HEIGHT
        ); // Draw the man's right leg
        g2.drawLine(
                manXPosition + MAN_HEAD_DIAMETER/2,
                manYBottomofTorso,
                manXPosition + MAN_HEAD_DIAMETER/2 - MAN_LEG_WIDTH,
                manYBottomofTorso + MAN_LEG_HEIGHT
        ); // Draw the man's left leg
    }
}
