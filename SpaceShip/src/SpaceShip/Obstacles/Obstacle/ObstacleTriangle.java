package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Geometry.Point;

public class ObstacleTriangle extends Obstacle {
    public final Point[] tops = new Point[3];

    public ObstacleTriangle(Point origin, int background_color, Point[] tops) {
        super(origin, background_color);

        System.arraycopy(tops, 0, this.tops, 0, this.tops.length);
    }

    @Override
    public void draw() {

    }
}
