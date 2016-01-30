package GUI.hangman;

import javax.swing.*;
import java.awt.*;

/***************************************************************
 * file: HangmanWordPanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: The Panel upon which is drawn the partially solved word
 *
 ****************************************************************/
public class HangmanWordPanel extends JPanel {

    private String mWord = "";
    private int mWordLength = 0;
    private char[] mLetters = "".toCharArray();

    public HangmanWordPanel() {

    }

    public void setWordLength(int length) {
        mWordLength = length;
        mLetters = new char[mWordLength];
    }

    public int getWordLength() {
        return mWordLength;
    }

    public char[] getLetters() {
        return mLetters;
    }

    public void setLetters(char[] letters) {
        mLetters = letters;
    }

    public void addLetter(int i, char c) throws Exception {
        if (i > mLetters.length) {
            throw new Exception("You suck");
        } else {
            mLetters[i] = c;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int LETTER_WIDTH = 40;
        final int LINE_THICKNESS = 5;
        final int LETTER_MARGIN = 2;
        final int TOTAL_CHARACTERS_WIDTH = (LETTER_MARGIN * 2 * mLetters.length) + (LETTER_WIDTH * mLetters.length);
        final int CENTERING_MARGIN = (getWidth() - TOTAL_CHARACTERS_WIDTH)/2;

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Comic Sans MS", Font.BOLD, 18);
        g2.setFont(font);
        g.setColor(Color.BLACK);
        for (int i = 0; i < mLetters.length; i++) {
            g2.drawString(
                    Character.toString(mLetters[i]).toUpperCase(),
                    (LETTER_MARGIN * 2 * i) + (LETTER_WIDTH * i) + CENTERING_MARGIN + LETTER_WIDTH/2 - font.getSize()/2,
                    getHeight() - LINE_THICKNESS - 12
            );
            g.fillRect(
                    (LETTER_MARGIN * 2 * i) + (LETTER_WIDTH * i) + CENTERING_MARGIN,
                    getHeight() - LINE_THICKNESS,
                    LETTER_WIDTH,
                    LINE_THICKNESS
            );
        }
    }
}
