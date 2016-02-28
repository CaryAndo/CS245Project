package GUI.panels;

import GUI.ImagePanel;
import callbacks.NavigationCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***************************************************************
 * file: MainMenuPanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: The Panel that holds the main menu
 *
 ****************************************************************/
public class MainMenuPanel extends JPanel {

    private NavigationCallbacks mCallbacks;

    public MainMenuPanel() {
        super();

        initUI();
    }

    public MainMenuPanel(LayoutManager layout) {
        super(layout);

        initUI();
    }

    public MainMenuPanel(NavigationCallbacks callbacks) {
        this();

        this.mCallbacks = callbacks;
    }

    public MainMenuPanel(LayoutManager layout, NavigationCallbacks callbacks) {
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
        setBackground(Color.black);
        setPreferredSize(new Dimension(600, 400));

        /**
         * Main Logo picture
         * */
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setPreferredSize(new Dimension(200, 200));
        imagePanel.setStretch(true);
        imagePanel.setBackground(Color.black);

        /**
         * Start Button
         * */
        JButton startButton = new JButton();
        
        startButton.setToolTipText("Click this button to start the game");
        
        startButton.setText("Start");
        startButton.setActionCommand("START_GAME");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("START_GAME")) {
                    mCallbacks.startNewHangmanGame();
                }
            }
        });

        /**
         * "High Scores" Button
         * */
        JButton highScoresButton = new JButton();
        
        highScoresButton.setToolTipText("Click this button to see the top 5 scores");
        
        highScoresButton.setText("High Scores");
        highScoresButton.addActionListener(e -> {
            mCallbacks.startHighScoreScreen();
        });

        /**
         * Credits Button
         * */
        JButton creditsButton = new JButton();
        creditsButton.setText("Credits"); 
        creditsButton.setToolTipText("Click this button to see the credits for the creators of this program");
        
        creditsButton.addActionListener(e -> {
            mCallbacks.startCreditsScreen();
        });

        /**
         * Layout for the Panel
         * */
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 315, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(startButton, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(highScoresButton, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(creditsButton, GroupLayout.Alignment.TRAILING))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(startButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(highScoresButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(creditsButton)
                                .addContainerGap())
        );

        add(imagePanel);
    }
}
