package SpaceShip.Obstacles;

import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryFire;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryIce;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryWater;

public class ObstaclesProducer {
    public enum ObstacleFactoryType {ICE, FIRE, WHATER}

    public static ObstaclesFactory getObstaclesFactory(ObstacleFactoryType obstacles_type) {
        switch (obstacles_type) {
            case ICE:
                return new ObstaclesFactoryIce();
            case FIRE:
                return new ObstaclesFactoryFire();
            case WHATER:
                return new ObstaclesFactoryWater();
        }

        return null;
    }
}
