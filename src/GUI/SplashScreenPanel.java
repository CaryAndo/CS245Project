package GUI;

import callbacks.FrameCallbacks;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 1/13/16.
 */
public class SplashScreenPanel extends JPanel {

    FrameCallbacks mCallbacks;

    public SplashScreenPanel() {
        super();

        initUI();
    }

    public SplashScreenPanel(LayoutManager layout) {
        super(layout);

        initUI();
    }

    /**
     * Initialize the UI
     * */
    private void initUI() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(600, 400));

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
        splashSubtextLabel.setText("By team CaR");
        splashSubtextLabel.setForeground(Color.white);
        splashSubtextLabel.setHorizontalAlignment(JLabel.CENTER);
        splashSubtextLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 75, 0));

        add(splashTitleLabel, BorderLayout.NORTH); // Add JLabel to Panel
        add(splashSubtextLabel, BorderLayout.SOUTH); // Add JLabel to Panel
    }
}
