package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.IdealTriangle;

class IdealTriangleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new IdealTriangle();
    }
}
