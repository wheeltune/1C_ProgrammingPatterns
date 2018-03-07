package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Origin;

public abstract class Obstacle {
    public Origin origin;
    public int background_color;

    public Obstacle(Origin origin, int background_color) {
        this.origin = origin;
        this.background_color = background_color;
    }

    public abstract void draw();
}
