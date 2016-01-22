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
