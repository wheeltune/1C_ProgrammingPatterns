package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Geometry.Point;
import SpaceShip.Obstacles.Obstacle.Obstacle;

public abstract class ObstaclesFactory {
    public enum ObstacleType {SQUARE, CIRCLE, TRIANGLE}

    public abstract Obstacle getObstacle(ObstacleType obstacle_type, Point origin);
}
