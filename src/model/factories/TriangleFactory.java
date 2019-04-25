package model.factories;

import shapes.Abstracts.ShapeFactory;
import shapes.Triangle;

class TriangleFactory extends ShapeFactory {
    @Override
    public Triangle createShape() {
        return new Triangle();
    }
}
