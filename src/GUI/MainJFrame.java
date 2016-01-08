package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cary on 1/8/16.
 */
public class MainJFrame extends JFrame {

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

        timer.start();
    }

    private void startSplashScreen() {
        BorderLayout splashLayout = new BorderLayout();

        /**
         * Splash Panel
         * */
        mSplashPanel = new JPanel(splashLayout);
        mSplashPanel.setBackground(Color.black);
        mSplashPanel.setPreferredSize(new Dimension(600, 400));

        /**
         * Title for Splash Screen
         * */
        JLabel splashTitleLabel = new JLabel();
        splashTitleLabel.setText("CS 245 Quarter Project");
        splashTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
        splashTitleLabel.setForeground(Color.white);
        splashTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        splashTitleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        /**
         * Subtext for Splash Screen
         * */
        JLabel splashSubtextLabel = new JLabel();
        splashSubtextLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        splashSubtextLabel.setText("By team caryAndRichard");
        splashSubtextLabel.setForeground(Color.white);
        splashSubtextLabel.setHorizontalAlignment(JLabel.CENTER);
        splashSubtextLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 75, 0));

        mSplashPanel.add(splashTitleLabel, BorderLayout.NORTH); // Add JLabel to Panel
        mSplashPanel.add(splashSubtextLabel, BorderLayout.SOUTH); // Add JLabel to Panel
        add(mSplashPanel, BorderLayout.CENTER); // Add JPanel to JFrame

        pack();
    }

    private void startMainMenu() {
        System.out.println("Starting the main menu");
        BorderLayout menuLayout = new BorderLayout();

        /**
         * Menu Panel
         * */
        mMenuPanel = new JPanel(menuLayout);
        mMenuPanel.setBackground(Color.red);
        mMenuPanel.setPreferredSize(new Dimension(600, 400));

        add(mMenuPanel, BorderLayout.CENTER);
        pack();
    }
}
