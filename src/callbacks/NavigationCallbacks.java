package callbacks;

import games.GameResults;


/***************************************************************
 * file: HangmanGamePanel.java
 * author: Cary Anderson and Richard Jung
 * class: CS 245 – GUI Programming
 *
 * assignment: Quarter Project
 * date last modified: 01/29/2016
 *
 * purpose: Interface that defines transitions to different screens in the app
 * So different classes can tell the implementing class to switch screens
 *
 ****************************************************************/
public interface NavigationCallbacks {

    void startSplashScreen();

    void startMainMenu();

    void startCreditsScreen();

    void startHighScoreScreen();

    void startNewHangmanGame();

    void startFinishScreen(GameResults results);
}
