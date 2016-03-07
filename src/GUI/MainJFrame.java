package GUI;

import GUI.panels.*;
import callbacks.NavigationCallbacks;
import games.GameResults;
import games.HighScoresFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private List<GameResults> mResultList; // Set of GameResults keeping track of all the games played (to summarize at the end)

    public MainJFrame() {
        super();

        mResultList = new ArrayList<>();

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
    //this method initializes the splash screen
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
    //this method initializes the main menu
    @Override
    public void startMainMenu() {
        
        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }
        
        JPanel mainMenuPanel = new MainMenuPanel(this);
        mCurrentScreenPanel = mainMenuPanel;
        
        add(mainMenuPanel, BorderLayout.CENTER);
        pack();
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "doStuffYeah");
        getRootPane().getActionMap().put("doStuffYeah", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayNamesOfTheAwesomeDevelopers();
            }
        });
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "doStuffYeah");
        getRootPane().getActionMap().put("doStuffYeah", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //this method shows the credit screen
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
    //displays the high scores screen
    @Override
    public void startHighScoreScreen() {
        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

       try {
            HighScoresFile hs = new HighScoresFile();
       }
       catch(Exception e) {
            e.printStackTrace();
       }
        
        JPanel highScoresPanel = new HighScorePanel(this);
        mCurrentScreenPanel = highScoresPanel;

        add(highScoresPanel, BorderLayout.CENTER);
        pack();
    }
    //starts a new hangman game
    @Override
    public void startNewHangmanGame() {
        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel hangmanGamePanel = new HangmanGamePanel(this);
        mCurrentScreenPanel = hangmanGamePanel;

        add(hangmanGamePanel, BorderLayout.CENTER);
        pack();
    }
    //starts the bubble click game
    @Override
    public void startBubbleClickGame(GameResults results) {
        mResultList = new ArrayList<>();

        if (results != null) {
            mResultList.add(results);
        }

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel bubbleClickGamePanel = new BubbleClickGamePanel(this);
        mCurrentScreenPanel = bubbleClickGamePanel;

        add(bubbleClickGamePanel, BorderLayout.CENTER);
        pack();
    }
    
    public void startSudokuGame(GameResults results) {
        mResultList = new ArrayList<>();

        if (results != null) {
            mResultList.add(results);
        }

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        JPanel sudokuPanel = new SudokuGamePanel(this);
        mCurrentScreenPanel = sudokuPanel;

        add(sudokuPanel, BorderLayout.CENTER);
        pack();
    }
    
    //displays the finish screen with results
    @Override
    public void startFinishScreen(GameResults results) {

        if (results != null) {
            mResultList.add(results);
        }

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        FinishScreenPanel finishScreenPanel = new FinishScreenPanel(this, mResultList);
        mCurrentScreenPanel = finishScreenPanel;

        add(finishScreenPanel, BorderLayout.CENTER);
        pack();
    } 
    
    @Override
    public void displayNamesOfTheAwesomeDevelopers() {
        startCreditsScreen();
    }
}
