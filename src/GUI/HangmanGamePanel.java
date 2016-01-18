package GUI;

import GUI.hangman.HangmanScaffoldPanel;
import GUI.hangman.HangmanWordPanel;
import callbacks.NavigationCallbacks;
import games.HangmanGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cary on 1/13/16.
 */
public class HangmanGamePanel extends JPanel {

    private NavigationCallbacks mCallbacks;
    private HangmanGame mGame;

    public HangmanGamePanel() {
        super();

        initUI();
    }

    public HangmanGamePanel(LayoutManager layout) {
        super(layout);

        initUI();
    }

    public HangmanGamePanel(NavigationCallbacks callbacks) {
        this();

        this.mCallbacks = callbacks;
    }

    public HangmanGamePanel(LayoutManager layout, NavigationCallbacks callbacks) {
        this(layout);

        this.mCallbacks = callbacks;
    }

    public void setCallbacks(NavigationCallbacks callbacks) {
        this.mCallbacks = callbacks;
    }

    /**
     * Initialize the UI
     * */
    private void initUI() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 400));

        GridLayout lettersLayout = new GridLayout(2, 13);

        // TODO: rename these panels
        final HangmanScaffoldPanel hangmanScaffoldPanel = new HangmanScaffoldPanel();
        HangmanWordPanel hangmanWordPanel = new HangmanWordPanel();
        JPanel inputLettersPanel = new JPanel();

        hangmanScaffoldPanel.setBackground(new Color(255, 255, 255));

        GroupLayout scaffoldLayout = new GroupLayout(hangmanScaffoldPanel);
        hangmanScaffoldPanel.setLayout(scaffoldLayout);
        scaffoldLayout.setHorizontalGroup(
                scaffoldLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        scaffoldLayout.setVerticalGroup(
                scaffoldLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 164, Short.MAX_VALUE)
        );

        hangmanWordPanel.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel2Layout = new GroupLayout(hangmanWordPanel);
        hangmanWordPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        inputLettersPanel.setBackground(new Color(255, 255, 255));

        mGame = new HangmanGame("test", hangmanWordPanel, hangmanScaffoldPanel);

        inputLettersPanel.setLayout(lettersLayout);
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            JButton tempButton = new JButton(Character.toString(c));
            tempButton.setMinimumSize(new Dimension(20, 20));
            tempButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mGame.attemptLetter(c);
                    /*if (!mGame.attemptLetter(c)) {
                        hangmanScaffoldPanel.addNextBodyPart();
                    }*/
                }
            });
            inputLettersPanel.add(tempButton);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(hangmanScaffoldPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputLettersPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(hangmanWordPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hangmanScaffoldPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hangmanWordPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputLettersPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }
}
