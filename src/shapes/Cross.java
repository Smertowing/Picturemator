package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Cross extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
        gc.strokeLine(secondPoint.x, firstPoint.y, firstPoint.x, secondPoint.y);
    }
}
