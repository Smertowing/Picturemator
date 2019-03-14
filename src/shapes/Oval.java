package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape {
    @Override
    public void drawOn(GraphicsContext gc) {
        gc.strokeOval((firstPoint.x < secondPoint.x ? firstPoint.x : secondPoint.x),
                (firstPoint.y < secondPoint.y ? firstPoint.y : secondPoint.y),
                Math.abs(secondPoint.x - firstPoint.x),
                Math.abs(secondPoint.y - firstPoint.y));
    }
}
