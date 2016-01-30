package GUI;

import GUI.panels.*;
import callbacks.NavigationCallbacks;
import games.GameResults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***************************************************************
 * file: MainJFrame.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: This is the Main JFrame where everything takes place
 *
 ****************************************************************/
public class MainJFrame extends JFrame implements NavigationCallbacks {

    private JPanel mCurrentScreenPanel; // A reference to the current JPanel that is being displayed in the window

    public MainJFrame() {
        super();
        initUI();
    }

    /**
     * Init the GUI components
     * */
    private void initUI() {
        setPreferredSize(new Dimension(600, 400)); // Set Window size
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Tell the app to close when we want it to

        setTitle("Project 1");
        startSplashScreen();

        setLocationRelativeTo(null); // Center the Window

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMainMenu();
            }
        });
        timer.setRepeats(false);
        timer.start(); // gogogogogo
    }

    @Override
    public void startSplashScreen() {
        BorderLayout splashLayout = new BorderLayout();

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel splashScreenPanel = new SplashScreenPanel(splashLayout);
        mCurrentScreenPanel = splashScreenPanel;

        add(splashScreenPanel, BorderLayout.CENTER); // Add JPanel to JFrame
        pack();
    }

    @Override
    public void startMainMenu() {
        System.out.println("Starting the main menu");

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel mainMenuPanel = new MainMenuPanel(this);
        mCurrentScreenPanel = mainMenuPanel;

        add(mainMenuPanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void startCreditsScreen() {
        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel creditsPanel = new CreditsPanel(this);
        mCurrentScreenPanel = creditsPanel;

        add(creditsPanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void startHighScoreScreen() {
        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel highScoresPanel = new HighScorePanel(this);
        mCurrentScreenPanel = highScoresPanel;

        add(highScoresPanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void startNewHangmanGame() {
        System.out.println("Starting a new game!");

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel hangmanGamePanel = new HangmanGamePanel(this);
        mCurrentScreenPanel = hangmanGamePanel;

        add(hangmanGamePanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void startFinishScreen(GameResults results) {

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        FinishScreenPanel finishScreenPanel = new FinishScreenPanel(this, results);
        mCurrentScreenPanel = finishScreenPanel;

        add(finishScreenPanel, BorderLayout.CENTER);
        pack();
        // TODO: Create custom JPanel to display the results
    }
}
