package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.*;
import shapes.Interfaces.Editable;

import java.awt.geom.Point2D;

public class Triangle extends Shape implements Editable {
    @Override
    public void drawOn(GraphicsContext gc) {
        double width = Math.abs(betaPoint.x - alfaPoint.x);
        double height = Math.abs(betaPoint.y - alfaPoint.y) * (betaPoint.y < alfaPoint.y ? -1 : 1);

        gc.setStroke(borderColor);
        gc.strokePolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x - width},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);

        gc.setFill(innerColor);
        gc.fillPolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x - width},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);
    }

    public Triangle(Color borderColor, Color innerColor) {
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
