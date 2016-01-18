package callbacks;

/**
 * Interface that defines transitions to different screens in the app
 * So different classes can tell the implementing class to switch screens
 *
 * Created by cary on 1/13/16.
 */
public interface NavigationCallbacks {

    void startMainMenu();

    void startSplashScreen();

    void startNewHangmanGame();

    void startFinishScreen();
}
