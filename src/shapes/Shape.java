package shapes;

import shapes.Interfaces.Drawable;

import java.awt.geom.Point2D;

public abstract class Shape implements Drawable {

    Point2D.Double alfaPoint, betaPoint;

    public void setAlfaPoint(Point2D.Double alfaPoint) {
        this.alfaPoint = alfaPoint;
    }

    public void setBetaPoint(Point2D.Double betaPoint) {
        this.betaPoint = betaPoint;
    }
}
