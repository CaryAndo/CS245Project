package GUI;

import callbacks.FrameCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by cary on 1/13/16.
 */
public class MainMenuPanel extends JPanel {

    private FrameCallbacks mCallbacks;

    public MainMenuPanel() {
        super();

        initUI();
    }

    public MainMenuPanel(LayoutManager layout) {
        super(layout);

        initUI();
    }

    public MainMenuPanel(FrameCallbacks callbacks) {
        this();

        this.mCallbacks = callbacks;
    }

    public MainMenuPanel(LayoutManager layout, FrameCallbacks callbacks) {
        this(layout);

        this.mCallbacks = callbacks;
    }

    public void setCallbacks(FrameCallbacks callbacks) {
        this.mCallbacks = callbacks;
    }

    private void initUI() {
        setBackground(Color.black);
        setPreferredSize(new Dimension(600, 400));

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
                    mCallbacks.startNewGame();
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
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
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

        add(imagePanel);
    }
}
