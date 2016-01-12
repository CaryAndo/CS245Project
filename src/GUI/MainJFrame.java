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
        imagePanel.setPreferredSize(new Dimension(200, 200));
        imagePanel.setStretch(true);
        imagePanel.setBackground(Color.black);

        /**
         * Start Button
         * */
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.setActionCommand("START_GAME");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("START_GAME")) {
                    remove(mMenuPanel);
                    startNewGame();
                }
            }
        });

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

        mMenuPanel.add(imagePanel);

        add(mMenuPanel, BorderLayout.CENTER);
        pack();
    }

    private void startNewGame() {
        System.out.println("Starting a new game!");

        mGamePanel = new JPanel();
        mGamePanel.setBackground(Color.black);
        mGamePanel.setPreferredSize(new Dimension(600, 400));

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 0, 0));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 140, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new Color(150, 0, 0));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new Color(0, 0, 150));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        add(mGamePanel, BorderLayout.CENTER);
        pack();
    }
}
