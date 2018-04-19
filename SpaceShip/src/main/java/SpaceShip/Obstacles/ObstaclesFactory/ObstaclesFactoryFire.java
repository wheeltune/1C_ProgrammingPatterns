package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Geometry.Point;
import SpaceShip.Obstacles.Obstacle.Obstacle;
import SpaceShip.Obstacles.Obstacle.ObstacleCircle;
import SpaceShip.Obstacles.Obstacle.ObstacleRectangle;
import SpaceShip.Obstacles.Obstacle.ObstacleTriangle;

import java.awt.*;

public class ObstaclesFactoryFire extends ObstaclesFactory {
    @Override
    public Obstacle getObstacle(ObstacleType obstacle_type) {
        switch (obstacle_type) {
            case RECTANGLE:
                return new ObstacleRectangle(
                        new Point[]{
                                new Point(0, 0),
                                new Point(50, 50)
                        },
                        Color.RED);
            case CIRCLE:
                return new ObstacleCircle(50, Color.RED);
            case TRIANGLE:
                return new ObstacleTriangle(
                        new Point[]{
                                new Point(0, 0),
                                new Point(50, 0),
                                new Point(25, 50),
                        },
                        Color.RED);
        }
        return getObstacle(obstacle_type);
    }
}
