package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Geometry.Point;

public abstract class Obstacle {
    public Point origin;
    public int background_color;

    public Obstacle(Point origin, int background_color) {
        this.origin = origin;
        this.background_color = background_color;
    }

    public abstract void draw();
}
