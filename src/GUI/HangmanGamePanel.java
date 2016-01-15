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

        JPanel jPanel1 = new javax.swing.JPanel();
        JPanel jPanel2 = new javax.swing.JPanel();
        JPanel jPanel3 = new javax.swing.JPanel();


        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 164, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(150, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 150));

        jPanel3.setLayout(lettersLayout);
        for (int i = 0; i < 26; i++) {
            JButton tempButton = new JButton(Character.toString((char) ('A'+i)));
            tempButton.setPreferredSize(new Dimension(20, 20));
            tempButton.setMinimumSize(new Dimension(20, 20));
            jPanel3.add(tempButton);
        }

        /*javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 108, Short.MAX_VALUE)
        );*/

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }
}
