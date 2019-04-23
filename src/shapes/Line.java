package shapes;

import javafx.scene.canvas.GraphicsContext;
import shapes.Abstracts.Shape;

public class Line extends Shape {
    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
    }
}