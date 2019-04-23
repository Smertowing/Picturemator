package shapes;

import javafx.scene.canvas.GraphicsContext;
import shapes.Abstracts.Shape;

public class Rectangle extends Shape {
    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));

        gc.setFill(innerColor);
        gc.fillRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));
    }
}
