package shapes.Interfaces;

import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public interface Selectable {
    boolean isSelected(Point2D.Double point);
    void selectOn(GraphicsContext gc);
}
