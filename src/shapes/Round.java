package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Round extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {

        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.strokeOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side,
                side);
    }
}