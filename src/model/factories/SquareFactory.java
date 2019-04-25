package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Square;

class SquareFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Square();
    }
}
