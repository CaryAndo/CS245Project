/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.io.*;
import java.util.*;
import GUI.panels.HighScorePanel;
import games.GameResults;
/**
 *
 * @author Richard
 */
public class HighScoresFile {
    
    private ArrayList<String> names;
    //private GameResults results;
    private int currScore;
    private int lowScore;
    
    public HighScoresFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
        
        names = new ArrayList<String>();
        
        //read from file and add to the arraylist
        while(true) {
            String line = reader.readLine();
   
            if(line == null)
                break;
            
            names.add(line);
        }
       
        reader.close();
    };  
    //this method compares the current total score with the array of scores
    public boolean checkScores(int s) {
        currScore = s;
        lowScore = Integer.parseInt(names.get(getMin()).split(": ")[1]);
        
        if(currScore > lowScore)
            return true;
        else
            return false;
    }
    
    //adds the name and total score to list of scores
    public void addNameEntry(String nameEntry, int totalScore) {
        names.set(names.size() - 1, nameEntry + " : " + Integer.toString(totalScore));
        sortScores();
    } 
    
    //sorts the array list of scores in order
    public void sortScores() {
        String temp;
        int max, compareNum;
        
        for(int i = 0; i < names.size() - 1; i++) {
            max = Integer.parseInt(names.get(i).split(": ")[1]);
            
            for(int j= i+1; j < names.size(); j++) {
                compareNum = Integer.parseInt(names.get(j).split(": ")[1]);
            
                if(compareNum > max) {
                    temp = names.get(j);
                    names.set(j, names.get(i));
                    names.set(i, temp);
                }
            }
        } 
    } 
    
    //returns the index of min score from array
    public int getMin() {
        int temp, minIndex = names.size() - 1;
        int min = Integer.parseInt(names.get(0).split(": ")[1]);
        for(int i = 1; i < names.size(); i++) {
            temp = Integer.parseInt(names.get(i).split(": ")[1]);
            if(temp < min) {
                min = temp;
                minIndex = i;
            }
        } 
        return minIndex;
    }
    
    //writes updated list of high scores to file
    public void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("highscores.txt"));
        
        for(String line : names) 
            writer.write(line + '\n');
        
        writer.close();
    }
    
    public String getName(int i) {
        return names.get(i);
    }
}



    
