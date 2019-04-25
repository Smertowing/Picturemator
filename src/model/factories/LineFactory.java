package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Line;

class LineFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Line();
    }
}
