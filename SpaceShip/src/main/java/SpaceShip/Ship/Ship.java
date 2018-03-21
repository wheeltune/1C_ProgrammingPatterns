package SpaceShip.Ship;

import SpaceShip.Game;
import javafx.geometry.Point2D;

import java.awt.*;

public class Ship {
    public void paint(Graphics g) {
        g.drawRect(0, 0, 49, 49);
    }

    public double getHeight() {
        return 50;
    }

    public double getWidth() {
        return 50;
    }

    public double getSpeed() {
        return 0.0000005;
    }
}
