package shapes.Implementations;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;
import shapes.Interfaces.SaveLoadable;
import shapes.Interfaces.Selectable;

import java.awt.geom.Point2D;

public class Line extends Shape implements Selectable, Editable, SaveLoadable {

    public Line() {
        classname = "Line";
    }

    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
    }

    @Override
    public boolean isSelected(Point2D.Double point) {
        return (((point.x <= alfaPoint.x && point.x >= betaPoint.x) || (point.x >= alfaPoint.x && point.x <= betaPoint.x)) &&
                ((point.y <= alfaPoint.y && point.y >= betaPoint.y) || (point.y >= alfaPoint.y && point.y <= betaPoint.y)) &&
                (Math.abs(((alfaPoint.x - point.x) / (alfaPoint.y - point.y)) - ((alfaPoint.x - betaPoint.x) / (alfaPoint.y - betaPoint.y))) < 3));
    }

    @Override
    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        gc.setStroke(Color.BLUE);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);

        gc.setLineWidth(tempWidth);
    }

}