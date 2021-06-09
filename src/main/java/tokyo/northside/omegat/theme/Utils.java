package tokyo.northside.omegat.theme;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Utils {
    /**
     * Adjust a color by adding some constant to its RGB values, clamping to the
     * range 0-255.
     */
    static Color adjustRGB(Color color, int adjustment) {
        Color result = new Color(Math.max(0, Math.min(255, color.getRed() + adjustment)),
                Math.max(0, Math.min(255, color.getGreen() + adjustment)),
                Math.max(0, Math.min(255, color.getBlue() + adjustment)));
        return result;
    }

    static boolean isMacOSX() {
        return System.getProperty("os.name").contains("OS X");
    }

    static boolean isWindows() {
        return System.getProperty("os.name").startsWith("Windows");
    }

    static ImageIcon getIcon(String iconName) {
        URL resourceURL = Utils.class.getResource(iconName);
        Image image = Toolkit.getDefaultToolkit().getImage(resourceURL);
        return image == null ? null : new ImageIcon(image);
    }
}
