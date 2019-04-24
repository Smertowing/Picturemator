package shapes.Abstracts;

import javafx.scene.paint.Color;

public abstract class ShapeFactory {
    public abstract Shape createShape(Color borderColor, Color innerColor);
}