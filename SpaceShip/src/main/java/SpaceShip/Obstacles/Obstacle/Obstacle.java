package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Geometry.GameObject;

import java.awt.*;

public abstract class Obstacle implements GameObject {
    protected Color background_color;

    public Obstacle(Color background_color) {
        this.background_color = background_color;
    }

    public Color getBackgroundColor() {
        return background_color;
    }
}
