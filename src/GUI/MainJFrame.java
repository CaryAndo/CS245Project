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
    private JPanel mSplashPanel;
    private JPanel mMenuPanel;
    private JPanel mGamePanel;

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
        setVisible(true); // Show the Window

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(mSplashPanel);
                startMainMenu();
            }
        });
        timer.setRepeats(false);

        timer.start();
    }

    @Override
    public void startSplashScreen() {
        BorderLayout splashLayout = new BorderLayout();

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        mSplashPanel = new SplashScreenPanel(splashLayout);
        add(mSplashPanel, BorderLayout.CENTER); // Add JPanel to JFrame

        pack();
    }

    @Override
    public void startMainMenu() {
        System.out.println("Starting the main menu");

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        mMenuPanel = new MainMenuPanel(this);
        mCurrentScreenPanel = mMenuPanel;

        add(mMenuPanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void startNewGame() {
        System.out.println("Starting a new game!");

        if (mCurrentScreenPanel != null) {
            remove(mCurrentScreenPanel);
        }

        mGamePanel = new HangmanGamePanel(this);
        mCurrentScreenPanel = mGamePanel;

        add(mGamePanel, BorderLayout.CENTER);
        pack();
    }
}
