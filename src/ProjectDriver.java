/***************************************************************
 * file: ProjectDriver.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: This is the main driver that starts the game
 *
 ****************************************************************/

import GUI.MainJFrame;

import javax.swing.*;

public class ProjectDriver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainJFrame mainJFrame = new MainJFrame();
                mainJFrame.setVisible(true); // Show the Window
            }
        });
    }
}
