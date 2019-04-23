package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
    }
}