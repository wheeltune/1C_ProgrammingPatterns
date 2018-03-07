package SpaceShip;

import SpaceShip.Geometry.ScreenSize;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Ship.Ship;

public class Game {
    public enum Location {ICE, FIRE, WATER}

    private static Game instance;

    private ScreenSize screenSize = new ScreenSize(800, 400);
    private Ship ship = new Ship();
    private ObstaclesFactory obstacles_factory;

    private Game() {
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setScreenSize(ScreenSize screen_size) {
        this.screenSize = screen_size;
    }

    public ScreenSize getScreenSize() {
        return screenSize;
    }

    public void run() {

    }
}