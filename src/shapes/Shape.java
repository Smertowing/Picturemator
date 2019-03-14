package shapes;

import java.awt.geom.Point2D;

public abstract class Shape implements Drawable {

    Point2D.Double firstPoint, secondPoint;

    public void setFirstPoint(Point2D.Double firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point2D.Double secondPoint) {
        this.secondPoint = secondPoint;
    }
}
