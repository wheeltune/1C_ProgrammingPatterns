package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Origin;

public class ObstacleCircle extends Obstacle {
    public float radius;

    public ObstacleCircle(Origin origin, int background_color, int radius) {
        super(origin, background_color);

        this.radius = radius;
    }

    @Override
    public void draw() {

    }
}
