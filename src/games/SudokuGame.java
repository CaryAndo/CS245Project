/***************************************************************
 * file: SudokuGame.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 03/03/2016
 *
 * purpose: This is where all the logic of the sudoku game happens
 *          checking status of game, incorrect guesses, points, etc.
 ****************************************************************/
package games;

import GUI.panels.SudokuGamePanel;
import java.awt.Color;

import javax.swing.*;

public class SudokuGame {
    private static boolean mIsGameOver;
    private static int mPoints = 540;
    private static int incorrectGuesses;
    
    private static final int[][] SUDOKU = {{8, 3, 5, 4, 1, 6, 9, 2, 7},
                                           {2, 9, 6, 8, 5, 7, 4, 3, 1},
                                           {4, 1, 7, 2, 9, 3, 6, 5, 8},
                                           {5, 6, 9, 1, 3, 4, 7, 8, 2},
                                           {1, 2, 3, 6, 7, 8, 5, 4, 9},
                                           {7, 4, 8, 5, 2, 9, 1, 6, 3},
                                           {6, 5, 2, 7, 8, 1, 3, 9, 4},
                                           {9, 8, 1, 3, 4, 5, 2, 7, 6},
                                           {3, 7, 4, 9, 6, 2, 8, 1, 5}};
    
    private static boolean [][] flag = {{false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false}};
    //constructor
    public SudokuGame() {
        
    }
    
    //scans SUDOKU inputs tracks wrong inputs and modifies score accordingly
    public void checkSubmit(JTextField [][] cells) {      
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                if(flag[i][j] == true)
                    ;
                else if(cells[i][j].getText().equals("") || 
                        Integer.parseInt(cells[i][j].getText()) != SUDOKU[i][j]) {
                    flag[i][j] = true;
                    mPoints -= 10;
                } 
            }
        }   
    }
    //checks if overall attempt is incorrect
    public boolean isIncorrect(JTextField[][] cells) {
        incorrectGuesses = 0;
        for(int i = 0; i < cells.length; i++) {
            for(int j= 0; j < cells[0].length; j++) {
                if(cells[i][j].getText().equals("") || 
                    Integer.parseInt(cells[i][j].getText()) != SUDOKU[i][j]) {
                    incorrectGuesses++;
                }
            }
        }
        
        return incorrectGuesses > 0;    
    }
    
    //sends the SUDOKU solution
    public int[][] getPuzzle() {
        return SUDOKU;
    }
    
    //verifies that all the puzzle fields are filled with valid numbers
    public boolean isComplete(JTextField [][] cells) {
        for(int i = 0; i < cells.length; i++)
            for(int j = 0; j < cells[0].length; j++)
                if(cells[i][j].getText().equals("")) {
                    return false;
                }              
        return true;       
    }
    
    //returns status of game over
    public boolean isGameOver() {
        if(incorrectGuesses == 0) {
            mIsGameOver = true;
        }
        else
            mIsGameOver = false;
        
        return mIsGameOver;
    }
    
    //returns the results of the game
    public GameResults getGameResults() {
        GameResults results = new GameResults();
        results.setDidFinish(mIsGameOver);
        results.setPoints(mPoints);
        return results;
    }
}
