package games;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cary on 2/3/16.
 */
public class BubbleClickGame {

    private String mColorName;
    private static Map<Color, String> mColorMap = new HashMap<>();

    static {
        mColorMap.put(Color.RED, "Red");
        mColorMap.put(Color.GREEN, "Green");
        mColorMap.put(Color.BLUE, "Blue");
        mColorMap.put(Color.YELLOW, "Yellow");
        mColorMap.put(Color.ORANGE, "Orange");
        mColorMap.put(Color.PINK, "Pink");
        mColorMap.put(Color.WHITE, "White");
        mColorMap.put(Color.WHITE, "White");
    }

    public BubbleClickGame() {

    }

    public BubbleClickGame(Color color) {

    }

}
