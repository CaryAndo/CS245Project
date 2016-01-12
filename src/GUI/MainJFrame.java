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
        timer.setRepeats(false);

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

        /**
         * Menu Panel
         * */
        mMenuPanel = new JPanel();
        mMenuPanel.setBackground(Color.black);
        mMenuPanel.setPreferredSize(new Dimension(600, 400));

        /**
         * Main Logo picture
         * */
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setPreferredSize(new Dimension(200, 100));
        imagePanel.setStretch(true);
        imagePanel.setBackground(Color.black);

        /**
         * Start Button
         * */
        JButton startButton = new JButton();
        startButton.setText("Start");

        /**
         * "High Scores" Button
         * */
        JButton highScoresButton = new JButton();
        highScoresButton.setText("High Scores");

        /**
         * Credits Button
         * */
        JButton creditsButton = new JButton();
        creditsButton.setText("Credits");

        /**
         * Layout for the Panel
         * */
        GroupLayout layout = new GroupLayout(mMenuPanel);
        mMenuPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 315, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(highScoresButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(creditsButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(highScoresButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(creditsButton)
                                .addContainerGap())
        );

        mMenuPanel.add(imagePanel);

        //GroupLayout menuLayout = new GroupLayout(mMenuPanel);

        add(mMenuPanel, BorderLayout.CENTER);
        pack();
    }
}
