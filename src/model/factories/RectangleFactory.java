package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Rectangle;

class RectangleFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
