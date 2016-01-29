package GUI.panels;

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
    private Timer mFinishTransitionTimer = null;

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

        GridLayout lettersLayout = new GridLayout(2, 14);

        /**
         * The Scaffold JPanel, on which is drawn the man to be hanged...
         * */
        final HangmanScaffoldPanel hangmanScaffoldPanel = new HangmanScaffoldPanel();
        hangmanScaffoldPanel.setBackground(new Color(255, 255, 255));

        /**
         * The JPanel that will hold all the partially filled in word
         * */
        HangmanWordPanel hangmanWordPanel = new HangmanWordPanel();
        hangmanWordPanel.setBackground(new Color(255, 255, 255));

        /**
         * The JPanel that holds all the letter buttons
         * */
        JPanel inputLettersPanel = new JPanel();
        inputLettersPanel.setBackground(new Color(255, 255, 255));

        /**
         * Button to skip the game
         * */
        JButton skipButton = new JButton();
        skipButton.setMinimumSize(new Dimension(20, 20));
        skipButton.setText("Skip");
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCallbacks.startFinishScreen(mGame.getGameResults());
            }
        });

        /**
         * Layout for the Scaffold Panel
         * */
        GroupLayout scaffoldLayout = new GroupLayout(hangmanScaffoldPanel);
        hangmanScaffoldPanel.setLayout(scaffoldLayout);
        scaffoldLayout.setHorizontalGroup(
                scaffoldLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(skipButton)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        scaffoldLayout.setVerticalGroup(
                scaffoldLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(skipButton)
                        .addGap(0, 164, Short.MAX_VALUE)
        );

        /**
         * Layout for the Hangman Word Panel
         * */
        GroupLayout hangmanWordPanelLayout = new GroupLayout(hangmanWordPanel);
        hangmanWordPanel.setLayout(hangmanWordPanelLayout);
        hangmanWordPanelLayout.setHorizontalGroup(
                hangmanWordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        hangmanWordPanelLayout.setVerticalGroup(
                hangmanWordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        /**
         * Initialize the Game State Object
         * */
        mGame = new HangmanGame("HelloWorld", hangmanWordPanel, hangmanScaffoldPanel);

        /**
         * Initialize the letter buttons
         * */
        inputLettersPanel.setLayout(lettersLayout);
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            JButton tempButton = new JButton(Character.toString(c));
            tempButton.setMinimumSize(new Dimension(20, 20));
            tempButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mGame.attemptLetter(c);
                    tempButton.setEnabled(false);
                    if (mGame.isGameOver() && mFinishTransitionTimer == null) {
                        mFinishTransitionTimer = new Timer(
                                3000,
                                a -> mCallbacks.startFinishScreen(mGame.getGameResults())
                        );
                        mFinishTransitionTimer.setRepeats(false);
                        mFinishTransitionTimer.start();
                    }
                }
            });
            inputLettersPanel.add(tempButton);
        }

        /**
         * Add all the Components to the Layout
         * */
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
