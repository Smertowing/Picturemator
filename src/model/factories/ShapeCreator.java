package model.factories;

import javafx.scene.paint.Color;
import shapes.*;
import shapes.Abstracts.*;
import java.util.HashMap;
import java.util.Map;

public class ShapeCreator {

    private ShapeFactory currentFactory;
    private Map<String, ShapeFactory> factories = new HashMap<>();

    public ShapeCreator(String currentFactory) {
        factories.put("Line", new LineFactory());
        factories.put("Round", new RoundFactory());
        factories.put("Rectangle", new RectangleFactory());
        factories.put("Oval", new OvalFactory());
        factories.put("IdealTriangle", new IdealTriangleFactory());
        factories.put("Triangle", new TriangleFactory());
        this.currentFactory = factories.get(currentFactory);
    }

    public Shape create(Color borderColor, Color innerColor) {
        return currentFactory.createShape(borderColor, innerColor);
    }

    public void setCurrentFactory(String currentFactory) {
        this.currentFactory = factories.get(currentFactory);
    }
}

class LineFactory extends ShapeFactory {

    @Override
    public Shape createShape(Color borderColor, Color innerColor) {
        return new Line(borderColor, innerColor);
    }
}

class OvalFactory extends ShapeFactory {

    @Override
    public Shape createShape(Color borderColor, Color innerColor) {
        return new Oval(borderColor, innerColor);
    }
}

class RectangleFactory extends ShapeFactory {

    @Override
    public Shape createShape(Color borderColor, Color innerColor) {
        return new Rectangle(borderColor, innerColor);
    }
}

class IdealTriangleFactory extends ShapeFactory {
    @Override
    public Shape createShape(Color borderColor, Color innerColor) {
        return new IdealTriangle(borderColor, innerColor);
    }
}

class TriangleFactory extends ShapeFactory {
    @Override
    public Triangle createShape(Color borderColor, Color innerColor) {
        return new Triangle(borderColor, innerColor);
    }
}

class RoundFactory extends ShapeFactory {
    @Override
    public Shape createShape(Color borderColor, Color innerColor) {
        return new Round(borderColor, innerColor);
    }
}