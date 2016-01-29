package GUI.panels;

import callbacks.NavigationCallbacks;
import games.GameResults;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Richard on 1/18/16.
 */
public class FinishScreenPanel extends JPanel {

    private NavigationCallbacks mCallbacks;
    private GameResults mGameResults;

    private ImageIcon image;
    private JLabel imageLabel;
    private JLabel scoreLabel;
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JButton button;

    public FinishScreenPanel(NavigationCallbacks callbacks, GameResults results) {
        super();
        this.mCallbacks = callbacks;
        this.mGameResults = results;
        initUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void initUI() {
        setBackground(Color.BLACK);

        scoreLabel = new JLabel();
        scoreLabel.setText("Score: " + mGameResults.getPoints());
        scoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);

        if (!mGameResults.didFinish()) {
            image = new ImageIcon("wat.jpg");
        } else if (mGameResults.didWin()) {
            image = new ImageIcon("pokemon.png");
        } else {
            image = new ImageIcon("vader.jpg");
        }

        //create an image object and place in label

        imageLabel = new JLabel("", image, JLabel.CENTER);

        //create a panel object and place image label
        imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        //add the imagelabel to the frame
        add(imageLabel);
        //frm.setResizable(false);

        //create back button and place in panel
        button = new JButton("End");
        button.addActionListener(e -> mCallbacks.startMainMenu());

        //this.setLayout(new BorderLayout());
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(flowLayout);
        buttonPanel.add(button);
        buttonPanel.add(scoreLabel);

        add(buttonPanel, BorderLayout.SOUTH);

        //set the frame visible
        setVisible(true);
    }
}
