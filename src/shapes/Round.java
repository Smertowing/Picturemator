package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;

public class Round extends Shape implements Editable {
    @Override
    public void drawOn(GraphicsContext gc) {
        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.setStroke(borderColor);
        gc.strokeOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side, side);

        gc.setFill(innerColor);
        gc.fillOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side, side);
    }

    public Round(Color borderColor, Color innerColor) {
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
