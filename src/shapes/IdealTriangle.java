package shapes;

import javafx.scene.canvas.GraphicsContext;

public class IdealTriangle extends Shape {

    @Override
    public void drawOn(GraphicsContext gc) {
        double width = Math.abs(secondPoint.x - firstPoint.x) * (secondPoint.x < firstPoint.x ? -1 : 1);
        double height = Math.abs(secondPoint.y - firstPoint.y) * (secondPoint.y < firstPoint.y ? -1 : 1);

        gc.strokePolygon(new double[]{firstPoint.x, firstPoint.x + width, firstPoint.x},
                new double[]{firstPoint.y, firstPoint.y + height, firstPoint.y + height}, 3);
    }
}
