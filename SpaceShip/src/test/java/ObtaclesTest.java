import SpaceShip.Game;
import SpaceShip.Obstacles.Obstacle.ObstacleCircle;
import SpaceShip.Obstacles.Obstacle.ObstacleRectangle;
import SpaceShip.Obstacles.Obstacle.ObstacleTriangle;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryFire;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryIce;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactoryWater;
import SpaceShip.Obstacles.ObstaclesProducer;
import org.junit.jupiter.api.Test;

import java.awt.*;

class ObtaclesTest {
    @Test
    void shouldProduceDifferentFactories() {
        assert (ObstaclesProducer.getObstaclesFactory(Game.Location.ICE) instanceof ObstaclesFactoryIce);
        assert (ObstaclesProducer.getObstaclesFactory(Game.Location.FIRE) instanceof ObstaclesFactoryFire);
        assert (ObstaclesProducer.getObstaclesFactory(Game.Location.WATER) instanceof ObstaclesFactoryWater);
    }

    @Test
    void shouldProduceDifferentObstacles() {
        ObstaclesFactory ice = ObstaclesProducer.getObstaclesFactory(Game.Location.ICE);
        ObstaclesFactory fire = ObstaclesProducer.getObstaclesFactory(Game.Location.FIRE);
        ObstaclesFactory water = ObstaclesProducer.getObstaclesFactory(Game.Location.WATER);

        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE) instanceof ObstacleTriangle);
        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE) instanceof ObstacleCircle);
        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE) instanceof ObstacleRectangle);
        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE).getBackgroundColor() == Color.BLUE);
        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE).getBackgroundColor() == Color.BLUE);
        assert (ice.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE).getBackgroundColor() == Color.BLUE);

        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE) instanceof ObstacleTriangle);
        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE) instanceof ObstacleCircle);
        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE) instanceof ObstacleRectangle);
        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE).getBackgroundColor() == Color.RED);
        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE).getBackgroundColor() == Color.RED);
        assert (fire.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE).getBackgroundColor() == Color.RED);

        assert (water.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE) instanceof ObstacleTriangle);
        assert (water.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE) instanceof ObstacleCircle);
        assert (water.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE) instanceof ObstacleRectangle);
        assert (water.getObstacle(ObstaclesFactory.ObstacleType.TRIANGLE).getBackgroundColor() == Color.YELLOW);
        assert (water.getObstacle(ObstaclesFactory.ObstacleType.CIRCLE).getBackgroundColor() == Color.YELLOW);
        assert (water.getObstacle(ObstaclesFactory.ObstacleType.RECTANGLE).getBackgroundColor() == Color.YELLOW);
    }
}
