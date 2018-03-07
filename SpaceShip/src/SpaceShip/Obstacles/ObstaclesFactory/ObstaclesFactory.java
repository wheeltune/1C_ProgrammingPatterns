package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Obstacles.Obstacle.Obstacle;
import SpaceShip.Origin;

public abstract class ObstaclesFactory {
    public enum ObstacleType {SQUARE, CIRCLE, TRIANGLE}

    public abstract Obstacle getObstacle(ObstacleType obstacle_type, Origin origin);
}
