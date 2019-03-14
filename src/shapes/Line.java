package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
    }
}
