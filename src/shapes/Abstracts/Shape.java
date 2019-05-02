package shapes.Abstracts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Interfaces.Drawable;

import java.awt.geom.Point2D;

public abstract class Shape implements Drawable {

    public Point2D.Double alfaPoint, betaPoint;
    protected Color innerColor, borderColor;
    protected String classname;

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

    public void showPointsOn(GraphicsContext gc) {
        gc.setFill(Color.DARKBLUE);
        gc.fillOval(alfaPoint.x-5,alfaPoint.y-5,11,11);
        gc.fillOval(betaPoint.x-5,betaPoint.y-5,11,11);
    }

    public void shift(Double deltaX, Double deltaY) {
        alfaPoint.x += deltaX;
        alfaPoint.y += deltaY;
        betaPoint.x += deltaX;
        betaPoint.y += deltaY;
    }

    public String wrap() {
        return classname + ';' + alfaPoint.x + ',' + alfaPoint.y + ';' + betaPoint.x + ',' + betaPoint.y + ';' + borderColor.toString() + ';' + innerColor.toString() + '\n';
    }
    public boolean unwrap(String description) {
        String[] cols = description.split(";");
        try {
            classname = cols[0];

            String[] aPoints = cols[1].split(",");
            alfaPoint = new Point2D.Double(Double.parseDouble(aPoints[0]), Double.parseDouble(aPoints[1]));

            String[] bPoints = cols[2].split(",");
            betaPoint = new Point2D.Double(Double.parseDouble(bPoints[0]), Double.parseDouble(bPoints[1]));

            borderColor = new Color(0.0,0.0,0.0,1);
            borderColor = Color.web(cols[3]);
            innerColor = new Color(0.0,0.0,0.0,1);
            innerColor = Color.web(cols[4]);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSelected(Point2D.Double point) {
        return (((point.x <= alfaPoint.x && point.x >= betaPoint.x) || (point.x >= alfaPoint.x && point.x <= betaPoint.x)) &&
                ((point.y <= alfaPoint.y && point.y >= betaPoint.y) || (point.y >= alfaPoint.y && point.y <= betaPoint.y)));
    }

    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        gc.setStroke(Color.BLUE);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));

        gc.setLineWidth(tempWidth);
    }

}
