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

/**
 * Created by cary on 2/3/16.
 */
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

    @Override
    public void click(Color color) {
        System.out.println("Attempting Color: " + color + " and current color is " + mGame.getCurrentColor());

        mGame.attemptColor(color);
        System.out.println("Current Score is: " + mGame.getPoints());

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

    private void setBubbles(ArrayList<Color> colors) {
        //System.out.println(colors);
        mJBubble1.setColor(colors.get(0));
        mJBubble2.setColor(colors.get(1));
        mJBubble3.setColor(colors.get(2));
        mJBubble4.setColor(colors.get(3));
        mJBubble5.setColor(colors.get(4));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawString(mCurrentDateString, getWidth() - 150, 20);
    }

    private void initUI() {

        mJBubble1 = new BubblePanel(this);
        mJBubble2 = new BubblePanel(this);
        mJBubble3 = new BubblePanel(this);
        mJBubble4 = new BubblePanel(this);
        mJBubble5 = new BubblePanel(this);
        jLabel1 = new JLabel();

        //mJBubble1.setColor(new Color(0, 0, 255));

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

        //mJBubble2.setColor(new Color(12, 80, 90));

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

        //mJBubble3.setColor(new Color(255, 0, 0));

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

        //mJBubble4.setColor(new Color(255, 114, 0));

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

        //mJBubble5.setColor(new Color(255, 50, 200));

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

        //setBubbles(mGame.getColors());
    }
}
