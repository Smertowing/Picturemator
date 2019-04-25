package model.factories;

import shapes.Abstracts.Shape;
import shapes.Abstracts.ShapeFactory;
import shapes.Oval;

class OvalFactory extends ShapeFactory {

    @Override
    public Shape createShape() {
        return new Oval();
    }
}
