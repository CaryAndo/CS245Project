package GUI;

import callbacks.NavigationCallbacks;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 1/18/16.
 */
public class FinishScreenPanel extends JPanel {

    private NavigationCallbacks mCallbacks;

    public FinishScreenPanel(NavigationCallbacks callbacks) {
        super();
        this.mCallbacks = callbacks;
        initUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void initUI() {
        JLabel tempLabel = new JLabel();
        tempLabel.setText("You finished a game!");
        tempLabel.setForeground(Color.WHITE);
        add(tempLabel);

        setBackground(Color.BLACK);
    }
}
