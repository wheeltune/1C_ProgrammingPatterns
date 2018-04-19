package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Geometry.Point;

import java.awt.*;

public class ObstacleRectangle extends Obstacle {
    private Polygon poly;
    private int width, height;

    public ObstacleRectangle(Point[] corner_tops, Color background_color) {
        super(background_color);

        Point min = new Point(corner_tops[0]), max = new Point(corner_tops[0]);
        if (corner_tops[1].x < min.x) min.x = corner_tops[1].x;
        else if (corner_tops[1].x > max.x) max.x = corner_tops[1].x;

        if (corner_tops[1].y < min.y) min.y = corner_tops[1].y;
        else if (corner_tops[1].y > max.y) max.y = corner_tops[1].y;

        width = max.x - min.x;
        height = max.y - min.y;

        int[] x_poly = {min.x, min.x, max.x, max.x};
        int[] y_poly = {min.y, max.y, max.y, min.y};
        poly = new Polygon(x_poly, y_poly, 4);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void paint(Graphics g) {
        Color temp_color = g.getColor();
        g.setColor(background_color);
        g.fillPolygon(poly);
        g.setColor(temp_color);
    }
}
