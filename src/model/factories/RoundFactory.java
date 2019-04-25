package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Round;

class RoundFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Round();
    }
}
