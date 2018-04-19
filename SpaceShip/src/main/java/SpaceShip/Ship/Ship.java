package SpaceShip.Ship;

import SpaceShip.Geometry.GameObject;

import java.awt.*;

public class Ship implements GameObject {
    @Override
    public void paint(Graphics g) {
        g.drawRect(0, 0, 49, 49);
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    public int getWidth() {
        return 50;
    }

    public double getSpeed() {
        return 0.000001;
    }
}
