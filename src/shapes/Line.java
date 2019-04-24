package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;

import java.awt.geom.Point2D;

public class Line extends Shape implements Editable {
    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
    }

    public Line(Color borderColor, Color innerColor) {
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }


    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}