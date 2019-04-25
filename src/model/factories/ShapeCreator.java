package model.factories;

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
        factories.put("Square", new SquareFactory());
        factories.put("Oval", new OvalFactory());
        factories.put("IdealTriangle", new IdealTriangleFactory());
        factories.put("Triangle", new TriangleFactory());
        this.currentFactory = factories.get(currentFactory);
    }

    public Shape create() {
        return currentFactory.createShape();
    }

    public void setCurrentFactory(String currentFactory) {
        this.currentFactory = factories.get(currentFactory);
    }
}

