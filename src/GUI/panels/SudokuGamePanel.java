/***************************************************************
 * file: SudokuGamePanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 03/03/2016
 *
 * purpose: The Panel that displays the sudoku game panel
 ****************************************************************/
package GUI.panels;
import GUI.bubble.BubblePanel;
import games.SudokuGame;

import callbacks.NavigationCallbacks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.border.Border;

public class SudokuGamePanel extends JPanel {
    
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel sudokuLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    private SudokuGame mGame;
    private NavigationCallbacks mCallbacks;
    private Timer mFinishTransitionTimer = null;
    
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String mCurrentDateString = dateFormat.format(Calendar.getInstance().getTime());
    
    private static final int GRID_SIZE = 9; 
    private static final int SUBGRID_SIZE = 3;  
    
    private static final int CELL_SIZE = 37;
    private static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
    private static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
    private static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 12);
    
    private JTextField[][] cells = new JTextField[GRID_SIZE][GRID_SIZE];
    private Listener input = new Listener();
    
    private SudokuGame sudoku = new SudokuGame();
    
    private boolean [][] masks = {{true, false, false, true, false, true, false, false, true},
                                  {false, false, false, false, false, false, true, false, false},
                                  {false, true, false, false, false, false, true, true, false},
                                  {true, false, true, false, true, false, true, true, false},
                                  {false, false, false, false, true, false, false, false, false},
                                  {false, true, true, false, true, false, true, false, true},
                                  {false, true, true, false, false, false, false, true, false},
                                  {false, false, true, false, false, false, false, false, false},
                                  {true, false, false, true, false, true, false, false, true}};
    
    //constructor
    public SudokuGamePanel(NavigationCallbacks callbacks) {
        this.mCallbacks = callbacks;
        this.mGame = new SudokuGame();
        
        //for the clock display
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCurrentDateString = dateFormat.format(Calendar.getInstance().getTime());
                repaint();
            }});

        timer.start();
        initUI();
    }
    
    //shows the clock
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawString(mCurrentDateString, getWidth() - 150, 20);
    }
    //initializes and manages the sudoku panel                        
    private void initUI() {

        jPanel1 = new javax.swing.JPanel();
        sudokuLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        quitButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        
        int [][] puzzle = sudoku.getPuzzle();
        
        sudokuLabel.setFont(new java.awt.Font("Nanum Brush Script", 1, 28)); // NOI18N
        sudokuLabel.setText("SUDOKU\n");
        
        //display and functionality of the Submit button
        submitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setToolTipText("Press this button to check your solution");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sudoku.isComplete(cells))
                    JOptionPane.showMessageDialog(null, "You must fill in all boxes!");
                else {
                    sudoku.checkSubmit(cells);
                
                    if(sudoku.isIncorrect())
                        JOptionPane.showMessageDialog(null, "Your submission is incorrect!\n" + 
                                "Try again or press Quit to exit");
                    else
                        JOptionPane.showMessageDialog(null, "Congratulations! You got it!");
                }
            }});
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sudokuLabel)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sudokuLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(49, 49, 49))
        );

        quitButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        quitButton.setText("Quit");
        quitButton.setToolTipText("Press this button to end the game");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sudoku.checkSubmit(cells);  
                mCallbacks.startFinishScreen(mGame.getGameResults());
            }});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(quitButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addGap(46, 46, 46))
        );
        
        jPanel3.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        
        //makes a sudoku object and adds listeners
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                cells[row][col] = new JTextField();
                
                if((col == 2 || col == 5) && (row == 2 || row == 5)) {
                    Border twoBorder = BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK);
                    cells[row][col].setBorder(twoBorder);
                }
                else if(col == 2 || col == 5) {     
                    Border twoBorder = BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLACK);
                    cells[row][col].setBorder(twoBorder);
                }
                else if(row == 2 || row == 5) {
                    Border bottomBorder = BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK);
                    cells[row][col].setBorder(bottomBorder);
                }
                else {
                    Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
                    cells[row][col].setBorder(border);
                }
                
                jPanel3.add(cells[row][col]);
                
                if(masks[row][col]) {
                    cells[row][col].setText(Integer.toString(puzzle[row][col]));
                    cells[row][col].setEditable(false);
                    cells[row][col].setForeground(Color.red);
                } else {   
                    cells[row][col].setText("");
                    cells[row][col].setEditable(true);
                    cells[row][col].setToolTipText("Input an integer from 1-9, then press Enter");
                    
                    cells[row][col].addFocusListener(input);
     
                }
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(FONT_NUMBERS);
            }
        }
        //sets the layout and look and feel of panel
        jPanel3.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        //jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>  
    
    //This class and overrided methods deals with input validation in the sudoku fields
    private class Listener implements FocusListener {
        //makes the textfield editable
        @Override
        public void focusGained(FocusEvent e) {
            JTextField source = (JTextField) e.getSource();
       
            source.setEditable(true);
        }
        //once the focus is lost on the text field, it validates the input
        @Override
        public void focusLost(FocusEvent e) {
            JTextField source = (JTextField) e.getSource();
            int field = 0;
            
            if(source.getText().equals(""))
                ;
            else {
                try {
                    field = Integer.parseInt(source.getText());
                    if(field > 9 || field < 1) {
                        JOptionPane.showMessageDialog(null, "You must enter an integer between 1 and 9!", 
                            "NOPE!!", JOptionPane.WARNING_MESSAGE);
                        source.setText("");
                    }

                } catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "You must enter an integer between 1 and 9!", 
                            "NOPE!!", JOptionPane.WARNING_MESSAGE);
                    System.out.println("Yo");
                    source.setText("");
                }           
            }  
        }
    }
}
    
