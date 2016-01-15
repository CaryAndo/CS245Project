package GUI;

import callbacks.FrameCallbacks;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cary on 1/13/16.
 */
public class HangmanGamePanel extends JPanel {

    private FrameCallbacks mCallbacks;

    public HangmanGamePanel() {
        super();

        initUI();
    }

    public HangmanGamePanel(LayoutManager layout) {
        super(layout);

        initUI();
    }

    public HangmanGamePanel(FrameCallbacks callbacks) {
        this();

        this.mCallbacks = callbacks;
    }

    public HangmanGamePanel(LayoutManager layout, FrameCallbacks callbacks) {
        this(layout);

        this.mCallbacks = callbacks;
    }

    public void setCallbacks(FrameCallbacks callbacks) {
        this.mCallbacks = callbacks;
    }

    /**
     * Initialize the UI
     * */
    private void initUI() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(600, 400));

        GridLayout lettersLayout = new GridLayout(2, 13);

        // TODO: rename these panels
        JPanel jPanel1 = new HangmanScaffoldPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        jPanel1.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 164, Short.MAX_VALUE)
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

        jPanel3.setLayout(lettersLayout);
        for (int i = 0; i < 26; i++) {
            JButton tempButton = new JButton(Character.toString((char) ('A'+i)));
            tempButton.setMinimumSize(new Dimension(20, 20));
            jPanel3.add(tempButton);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
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
    }
}
