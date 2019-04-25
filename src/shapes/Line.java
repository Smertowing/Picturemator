package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.*;
import shapes.Interfaces.*;

import java.awt.geom.Point2D;

public class Line extends Shape implements Selectable, Editable, Saveable {
    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
    }

    public boolean isSelected(Point2D.Double point) {
        return (((point.x <= alfaPoint.x && point.x >= betaPoint.x) || (point.x >= alfaPoint.x && point.x <= betaPoint.x)) &&
                ((point.x <= alfaPoint.y && point.x >= betaPoint.y) || (point.x >= alfaPoint.y && point.x <= betaPoint.y)) &&
                (Math.abs(((alfaPoint.x - point.x) / (alfaPoint.y - point.y)) - ((alfaPoint.x - betaPoint.x) / (alfaPoint.y - betaPoint.y))) < 3));
    }

    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        gc.setStroke(Color.BLUE);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);

        gc.setLineWidth(tempWidth);
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

}