/***************************************************************
 * file: BubbleClickGamePanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 02/11/2016
 *
 * purpose: This is the main component that initializes and defines 
 *          the layout of the bubble game panel and bubbles 
 *
 ****************************************************************/

package GUI.panels;

import GUI.bubble.BubblePanel;
import callbacks.BubbleClickCallbacks;
import callbacks.NavigationCallbacks;
import games.BubbleClickGame;
import games.BubbleClickGameRound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

/***************************************************************
 * file: BubbleClickGamePanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 02/11/2016
 *
 * purpose: This is the main component that initializes and defines
 *          the layout of the bubble game panel and bubbles
 *
 ****************************************************************/
public class BubbleClickGamePanel extends JPanel implements BubbleClickCallbacks {

    private JLabel jLabel1;
    private BubblePanel mJBubble1;
    private BubblePanel mJBubble2;
    private BubblePanel mJBubble3;
    private BubblePanel mJBubble4;
    private BubblePanel mJBubble5;

    private NavigationCallbacks mCallbacks;
    private BubbleClickGame mGame;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String mCurrentDateString = dateFormat.format(Calendar.getInstance().getTime());

    public BubbleClickGamePanel(NavigationCallbacks callbacks) {
        this.mCallbacks = callbacks;
        this.mGame = new BubbleClickGame();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCurrentDateString = dateFormat.format(Calendar.getInstance().getTime());
                repaint();
            }
        });

        timer.start();

        initUI();
        updateUIElements();
    }
    //checks to see if there were 5 clicks or 5 rounds played
    @Override
    public void click(Color color) {
        mGame.attemptColor(color);

        if (mGame.isGameOver()) {
            mCallbacks.startFinishScreen(mGame.getGameResults());
            return;
        }

        updateUIElements();
    }

    /**
     * Update UI components based on the current round being played
     * */
    private void updateUIElements() {
        ArrayList<Color> colors = mGame.getColors();
        setBubbles(colors);
        jLabel1.setForeground(mGame.getCurrentColor());

        ArrayList<Color> tempColorList = new ArrayList<>();

        /**
         * Add Colors that are not the special color to a temporary list
         * */
        for (Color potentialColor : colors) {
            if (!potentialColor.equals(mGame.getCurrentColor())) {
                tempColorList.add(potentialColor);
            }
        }

        jLabel1.setText(BubbleClickGameRound.getColorName(tempColorList.get(ThreadLocalRandom.current().nextInt(0, tempColorList.size()-1))));
    }
    //sets the colors of the bubbles
    private void setBubbles(ArrayList<Color> colors) {
        mJBubble1.setColor(colors.get(0)); 
        mJBubble1.setToolTipText("Click this bubble to select its color");
        
        mJBubble2.setColor(colors.get(1)); 
        mJBubble2.setToolTipText("Click this bubble to select its color");
        
        mJBubble3.setColor(colors.get(2));
        mJBubble3.setToolTipText("Click this bubble to select its color");
        
        mJBubble4.setColor(colors.get(3));
        mJBubble4.setToolTipText("Click this bubble to select its color");
        
        mJBubble5.setColor(colors.get(4));
        mJBubble5.setToolTipText("Click this bubble to select its color");
    }
    //shows the clock
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawString(mCurrentDateString, getWidth() - 150, 20);
    }
    //layout of the panel
    private void initUI() {

        mJBubble1 = new BubblePanel(this);
        mJBubble2 = new BubblePanel(this);
        mJBubble3 = new BubblePanel(this);
        mJBubble4 = new BubblePanel(this);
        mJBubble5 = new BubblePanel(this);
        jLabel1 = new JLabel();

        GroupLayout jPanel1Layout = new GroupLayout(mJBubble1);
        mJBubble1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 63, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(mJBubble2);
        mJBubble2.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 63, Short.MAX_VALUE)
        );

        GroupLayout jPanel4Layout = new GroupLayout(mJBubble3);
        mJBubble3.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 63, Short.MAX_VALUE)
        );

        GroupLayout jPanel5Layout = new GroupLayout(mJBubble4);
        mJBubble4.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 63, Short.MAX_VALUE)
        );

        GroupLayout jPanel6Layout = new GroupLayout(mJBubble5);
        mJBubble5.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 63, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("Click the bubble with the color of this word");
        
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 32));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(mJBubble2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mJBubble1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(mJBubble5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(mJBubble3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(152, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(276, Short.MAX_VALUE)
                                        .addComponent(mJBubble4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mJBubble1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mJBubble2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(mJBubble3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mJBubble5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(199, Short.MAX_VALUE)
                                        .addComponent(mJBubble4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
        );
    }
}
