package shapes.Interfaces;

import javafx.scene.canvas.GraphicsContext;

public interface Editable {
    void showPointsOn(GraphicsContext gc);
    void shift(Double deltaX, Double deltaY);
}