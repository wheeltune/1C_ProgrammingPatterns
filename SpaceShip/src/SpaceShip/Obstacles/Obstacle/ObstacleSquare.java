package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Origin;
import SpaceShip.Point;

public class ObstacleSquare extends Obstacle {
    public Point[] corner_tops = new Point[2];

    public ObstacleSquare(Origin origin, int background_color, Point[] corner_tops) {
        super(origin, background_color);

        System.arraycopy(corner_tops, 0, this.corner_tops, 0, this.corner_tops.length);
    }

    @Override
    public void draw() {

    }
}
