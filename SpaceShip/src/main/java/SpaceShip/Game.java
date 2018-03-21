package SpaceShip;

import SpaceShip.Geometry.ScreenSize;
import SpaceShip.Obstacles.ObstaclesFactory.ObstaclesFactory;
import SpaceShip.Ship.Ship;
import javafx.geometry.Point2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Dimension2D;

public class Game extends JPanel implements KeyListener, ActionListener {
    public enum Location {ICE, FIRE, WATER}
    public enum State { OFF, PLAYING, QUITING }
    public enum ShipState { NONE, MOVING_LEFT, MOVING_RIGHT }
    private State state = State.OFF;
    private ShipState ship_state = ShipState.NONE;

    private static Game instance;
    private Dimension screenSize = new Dimension(450, 700);

    private Ship ship = new Ship();
    private Point2D ship_pos = new Point2D(
            screenSize.width / 2,
            screenSize.height - ship.getHeight());
    private Timer ship_movement_timer = new Timer(10, this);
    private long last_movement_time_ns;

    private ObstaclesFactory obstacles_factory;

    private Game() {}
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

        while (state != State.QUITING) {
            repaint();
        }
    }

    public void paint(Graphics g) {
        Graphics shipGraphics = g.create((int) ship_pos.getX(),
                (int) ship_pos.getY(),
                (int) ship.getWidth(),
                (int) ship.getHeight());
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
                last_movement_time_ns = System.nanoTime();
                ship_movement_timer.start();
                break;
            case KeyEvent.VK_RIGHT:
                ship_state = ShipState.MOVING_RIGHT;
                last_movement_time_ns = System.nanoTime();
                ship_movement_timer.start();
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (ship_state == ShipState.MOVING_LEFT) {
                    ship_movement_timer.stop();
                    ship_state = ShipState.NONE;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (ship_state == ShipState.MOVING_RIGHT) {
                    ship_movement_timer.stop();
                    ship_state = ShipState.NONE;
                }
                break;
            default:
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        long lapsed_ns, current_time_ns;
        double dx;
        switch (ship_state) {
            case NONE:
                break;
            case MOVING_LEFT:
                current_time_ns = System.nanoTime();
                lapsed_ns = current_time_ns - last_movement_time_ns;
                last_movement_time_ns = current_time_ns;

                dx = lapsed_ns * ship.getSpeed();
                if (ship_pos.getX() - dx < 0) {
                    ship_pos = new Point2D(0, ship_pos.getY());
                } else {
                    ship_pos = ship_pos.subtract(dx, 0);
                }
                break;
            case MOVING_RIGHT:
                current_time_ns = System.nanoTime();
                lapsed_ns = current_time_ns - last_movement_time_ns;
                last_movement_time_ns = current_time_ns;

                dx = lapsed_ns * ship.getSpeed();
                if (ship_pos.getX() + ship.getWidth() + dx > screenSize.getWidth()) {
                    ship_pos = new Point2D(screenSize.getWidth() - ship.getWidth(), ship_pos.getY());
                } else {
                    ship_pos = ship_pos.add(dx, 0);
                }
                break;
        }
    }
}