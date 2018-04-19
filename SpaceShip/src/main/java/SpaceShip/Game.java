package SpaceShip;

import SpaceShip.Obstacles.Obstacle.Obstacle;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Obstacles.ObstaclesProducer;
import SpaceShip.Ship.Ship;
import javafx.geometry.Point2D;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Game extends JPanel implements KeyListener, ActionListener {
    private static Game instance;

    private Random rnd = new Random(System.currentTimeMillis());

    public enum Location {ICE, FIRE, WATER}

    private Location location = Location.ICE;

    public enum State { OFF, PLAYING, QUITING }
    private State state = State.OFF;

    public enum ShipState {NONE, MOVING_LEFT, MOVING_RIGHT}
    private ShipState ship_state = ShipState.NONE;

    private Timer game_timer = new Timer(10, this);
    private long last_time_ns;

    private double game_speed = 0.0000005;
    private double game_speed_up = 0.0000000001;

    private Dimension screenSize = new Dimension(450, 700);

    private Ship ship = new Ship();
    private Point2D ship_pos = new Point2D(
            screenSize.width / 2,
            screenSize.height - ship.getHeight() - 50);

    private ObstaclesFactory obstacles_factory;
    private Deque<Pair<Obstacle, Point>> obstacle_positions;
    private long next_obstacle_time = System.nanoTime();

    private Pair<Obstacle, Point> createObstacle() {
        ObstaclesFactory.ObstacleType obstacle_type =
                ObstaclesFactory.ObstacleType.values()[
                        rnd.nextInt(ObstaclesFactory.ObstacleType.values().length)];
        Obstacle new_obtacle = obstacles_factory.getObstacle(obstacle_type);
        return new Pair<>(new_obtacle,
                new Point(rnd.nextInt((int) (screenSize.getWidth() - new_obtacle.getWidth())), -new_obtacle.getHeight()));
    }

    private Game() {
        obstacles_factory = ObstaclesProducer.getObstaclesFactory(location);
        obstacle_positions = new ArrayDeque<>();

        obstacle_positions.add(createObstacle());
    }

    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void start() {
        JFrame frame = new JFrame("SpaceShip");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setSize(screenSize);
        frame.setResizable(false);

        frame.add(this);
        frame.addKeyListener(this);

        game_timer.start();
        last_time_ns = System.nanoTime();
        while (state != State.QUITING) {
            repaint();
        }
    }


    public void paint(Graphics g) {
        for (Pair<Obstacle, Point> obstacle_position : obstacle_positions) {
            Graphics shipGraphics = g.create(
                    obstacle_position.getValue().x,
                    obstacle_position.getValue().y,
                    obstacle_position.getKey().getWidth(),
                    obstacle_position.getKey().getHeight());
            obstacle_position.getKey().paint(shipGraphics);

            if (obstacle_position.getValue().getY() > screenSize.height) {
                obstacle_positions.pop();
            }
        }

        Graphics shipGraphics = g.create(
                (int) ship_pos.getX(),
                (int) ship_pos.getY(),
                ship.getWidth(),
                ship.getHeight());
        ship.paint(shipGraphics);
    }

    public void setScreenSize(Dimension screen_size) {
        this.screenSize = screen_size;
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public void keyTyped(KeyEvent e) {
        System.out.println(e.toString());
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                ship_state = ShipState.MOVING_LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                ship_state = ShipState.MOVING_RIGHT;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (ship_state == ShipState.MOVING_LEFT) {
                    ship_state = ShipState.NONE;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (ship_state == ShipState.MOVING_RIGHT) {
                    ship_state = ShipState.NONE;
                }
                break;
            default:
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        long current_time_ns = System.nanoTime();
        long lapsed_ns = current_time_ns - last_time_ns;

        double dx = lapsed_ns * ship.getSpeed();
        switch (ship_state) {
            case NONE:
                break;
            case MOVING_LEFT:
                if (ship_pos.getX() - dx < 0) {
                    ship_pos = new Point2D(0, ship_pos.getY());
                } else {
                    ship_pos = ship_pos.subtract(dx, 0);
                }
                break;
            case MOVING_RIGHT:
                if (ship_pos.getX() + ship.getWidth() + dx > screenSize.getWidth()) {
                    ship_pos = new Point2D(screenSize.getWidth() - ship.getWidth(), ship_pos.getY());
                } else {
                    ship_pos = ship_pos.add(dx, 0);
                }
                break;
        }

        dx = lapsed_ns * game_speed;
        game_speed += game_speed_up;

        for (Pair<Obstacle, Point> obstacle_position : obstacle_positions) {
            obstacle_position.getValue().y += dx;
        }
        if (current_time_ns > next_obstacle_time) {
            obstacle_positions.add(createObstacle());
            next_obstacle_time += rnd.nextInt(100000000) + 100000000;
        }


        last_time_ns = current_time_ns;
    }
}