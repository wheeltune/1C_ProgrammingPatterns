package SpaceShip.Obstacles;

import SpaceShip.Game;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryFire;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryIce;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryWater;

public class ObstaclesProducer {
    public static ObstaclesFactory getObstaclesFactory(Game.Location obstacles_type) {
        switch (obstacles_type) {
            case ICE:
                return new ObstaclesFactoryIce();
            case FIRE:
                return new ObstaclesFactoryFire();
            case WATER:
                return new ObstaclesFactoryWater();
        }

        return null;
    }
}
