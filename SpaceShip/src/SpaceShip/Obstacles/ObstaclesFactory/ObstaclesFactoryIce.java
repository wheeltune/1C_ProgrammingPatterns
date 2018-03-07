package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Geometry.Point;
import SpaceShip.Obstacles.Obstacle.Obstacle;
import SpaceShip.Obstacles.Obstacle.ObstacleCircle;
import SpaceShip.Obstacles.Obstacle.ObstacleSquare;
import SpaceShip.Obstacles.Obstacle.ObstacleTriangle;

public class ObstaclesFactoryIce extends ObstaclesFactory {
    @Override
    public Obstacle getObstacle(ObstacleType obstacle_type, Point origin) {
        switch (obstacle_type) {
            case SQUARE:
                return new ObstacleSquare(
                        origin,
                        2,
                        new Point[]{
                                new Point(0, 0),
                                new Point(0, 0)
                        });
            case CIRCLE:
                return new ObstacleCircle(
                        origin,
                        2,
                        2);
            case TRIANGLE:
                return new ObstacleTriangle(
                        origin,
                        2,
                        new Point[]{
                                new Point(0, 0),
                                new Point(0, 0),
                                new Point(0, 0),
                        });
        }

        return null;
    }
}
