package luke.nai.project.astar.gui;

import java.awt.Color;

/**
 *
 * @author LukaszDrapala
 */
public class ColorSupplier {

    private ColorSupplier() {
    }
    
    public static Color getDefaultColor() {
        return new Color(238, 238, 238);
    }
    public static Color getStartColor() {
        return Color.GREEN;
    }
    public static Color getEndColor() {
        return Color.ORANGE;
    }
    public static Color getWallColor() {
        return Color.RED;
    }
    public static Color getPathColor() {
        return Color.PINK;
    }

}
