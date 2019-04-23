package shapes.Abstracts;

import javafx.scene.paint.Color;
import shapes.Interfaces.Drawable;

import java.awt.geom.Point2D;

public abstract class Shape implements Drawable {

    protected Point2D.Double alfaPoint, betaPoint;
    protected javafx.scene.paint.Color innerColor, borderColor;

    public void setAlfaPoint(Point2D.Double alfaPoint) {
        this.alfaPoint = alfaPoint;
    }
    public void setBetaPoint(Point2D.Double betaPoint) {
        this.betaPoint = betaPoint;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
