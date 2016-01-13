package GUI;

import callbacks.FrameCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cary on 1/8/16.
 */
public class MainJFrame extends JFrame implements FrameCallbacks {

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
}
