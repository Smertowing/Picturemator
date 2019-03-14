package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape {
    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));
    }
}
