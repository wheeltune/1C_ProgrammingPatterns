package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Obstacles.Obstacle.Obstacle;

public abstract class ObstaclesFactory {
    public enum ObstacleType {RECTANGLE, CIRCLE, TRIANGLE}

    public abstract Obstacle getObstacle(ObstacleType obstacle_type);
}
