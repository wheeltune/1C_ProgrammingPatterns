package SpaceShip.Obstacles.ObstaclesFactory;

import SpaceShip.Obstacles.Obstacle.Obstacle;
import SpaceShip.Obstacles.Obstacle.ObstacleCircle;
import SpaceShip.Obstacles.Obstacle.ObstacleSquare;
import SpaceShip.Obstacles.Obstacle.ObstacleTriangle;
import SpaceShip.Origin;
import SpaceShip.Point;

public class ObstaclesFactoryWater extends ObstaclesFactory {
    @Override
    public Obstacle getObstacle(ObstacleType obstacle_type, Origin origin) {
        switch (obstacle_type) {
            case SQUARE:
                return new ObstacleSquare(
                        origin,
                        3,
                        new Point[]{
                                new Point(0, 0),
                                new Point(0, 0)
                        });
            case CIRCLE:
                return new ObstacleCircle(
                        origin,
                        3,
                        2);
            case TRIANGLE:
                return new ObstacleTriangle(
                        origin,
                        3,
                        new Point[]{
                                new Point(0, 0),
                                new Point(0, 0),
                                new Point(0, 0),
                        });
        }

        return null;
    }
}
