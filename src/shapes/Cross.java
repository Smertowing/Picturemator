package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Cross extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeLine(alfaPoint.x, alfaPoint.y, betaPoint.x, betaPoint.y);
        gc.strokeLine(betaPoint.x, alfaPoint.y, alfaPoint.x, betaPoint.y);
    }
}
