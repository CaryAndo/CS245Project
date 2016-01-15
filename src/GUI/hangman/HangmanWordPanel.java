package GUI.hangman;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 1/15/16.
 */
public class HangmanWordPanel extends JPanel {

    private String mWord = "";
    private int mWordLength = 0;
    private char[] letters = "".toCharArray();

    public HangmanWordPanel() {

    }

    public void setWordLength(int length) {
        mWordLength = length;
        letters = new char[mWordLength];
    }

    public int getWordLength() {
        return mWordLength;
    }

    public char[] getLetters() {
        return letters;
    }

    public void addLetter(int i, char c) throws Exception {
        if (i > letters.length) {
            throw new Exception("You suck");
        } else {
            letters[i] = c;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int LETTER_WIDTH = 40;
        final int LINE_THICKNESS = 5;
        final int LETTER_MARGIN = 2;
        final int TOTAL_CHARACTERS_WIDTH = (LETTER_MARGIN * 2 * letters.length) + (LETTER_WIDTH * letters.length);
        final int CENTERING_MARGIN = (getWidth() - TOTAL_CHARACTERS_WIDTH)/2;

        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Comic Sans MS", Font.BOLD, 18);
        g2.setFont(font);
        g.setColor(Color.BLACK);
        for (int i = 0; i < letters.length; i++) {
            g2.drawString(
                    Character.toString(letters[i]).toUpperCase(),
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
