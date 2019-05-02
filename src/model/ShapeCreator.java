package model;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Implementations.*;

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

    static class IdealTriangleFactory extends ShapeFactory {
        @Override
        public Shape createShape() {
            return new IdealTriangle();
        }
    }

    static class LineFactory extends ShapeFactory {
        @Override
        public Shape createShape() {
            return new Line();
        }
    }

    static class OvalFactory extends ShapeFactory {
        @Override
        public Shape createShape() {
            return new Oval();
        }
    }

    static class RectangleFactory extends ShapeFactory {
        @Override
        public Shape createShape() {
            return new Rectangle();
        }
    }

    static class RoundFactory extends ShapeFactory {
        @Override
        public Shape createShape() { return new Round(); }
    }

    static class SquareFactory extends ShapeFactory {
        @Override
        public Shape createShape() {
            return new Square();
        }
    }

    static class TriangleFactory extends ShapeFactory {
        @Override
        public Triangle createShape() {
            return new Triangle();
        }
    }
}

