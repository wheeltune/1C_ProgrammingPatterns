package SpaceShip.Obstacles.Obstacle;

import java.awt.*;

public class ObstacleCircle extends Obstacle {
    private int radius;

    public ObstacleCircle(int radius, Color background_color) {
        super(background_color);

        this.radius = radius;
    }

    @Override
    public int getHeight() {
        return 2 * radius;
    }

    @Override
    public int getWidth() {
        return 2 * radius;
    }

    @Override
    public void paint(Graphics g) {
        Color temp_color = g.getColor();
        g.setColor(background_color);
        g.fillArc(radius, radius, radius, radius, 0, 360);
        g.setColor(temp_color);
    }
}
