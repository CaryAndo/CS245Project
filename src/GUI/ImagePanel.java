package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by cary on 1/8/16.
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;
    private boolean mShouldStretch = false;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("./mainImage.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void setStretch(boolean shouldStretch) {
        mShouldStretch = shouldStretch;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mShouldStretch) {
            g.drawImage(
                    image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT),
                    0,
                    0,
                    null);
        } else {
            g.drawImage(image, 0, 0, null);
        }
    }
}
