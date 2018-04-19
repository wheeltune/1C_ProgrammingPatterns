package SpaceShip.Obstacles.Obstacle;

import SpaceShip.Geometry.Point;

import java.awt.*;

public class ObstacleTriangle extends Obstacle {
    private Polygon poly;

    private int width;
    private int height;

    public ObstacleTriangle(Point[] tops, Color background_color) {
        super(background_color);

        Point min = new Point(tops[0]), max = new Point(tops[0]);
        for (int i = 1; i < 3; ++i) {
            if (tops[i].x < min.x) {
                min.x = tops[i].x;
            } else if (tops[i].x > max.x) {
                max.x = tops[i].x;
            }

            if (tops[i].y < min.y) {
                min.y = tops[i].y;
            } else if (tops[i].y > max.y) {
                max.y = tops[i].y;
            }

        }

        width = max.x - min.x;
        height = max.y - min.y;

        int[] x_poly = {tops[0].x, tops[1].x, tops[2].x};
        int[] y_poly = {tops[0].y, tops[1].y, tops[2].y};
        poly = new Polygon(x_poly, y_poly, 3);
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
