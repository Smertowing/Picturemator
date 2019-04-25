package model;

import java.util.ArrayList;
import java.util.List;

import shapes.Abstracts.*;
import shapes.Interfaces.*;

public class ShapeConverter {

    public String wrap(ArrayList<Shape> shapes) {
        StringBuilder csv = new StringBuilder();

        shapes.forEach(
            shape -> {
                if(shape instanceof Saveable)
                    csv.append(((Saveable) shape).wrap());
            }
        );

        return csv.toString();
    }

    public StackOfShapes unwrap(List<String> rows) {
        StackOfShapes stack = new StackOfShapes();
        ShapeCreator shapeCreator = new ShapeCreator("");
        for(String row : rows) {
            String[] cols = row.split(";");
            String className = cols[0];
            shapeCreator.setCurrentFactory(className);
            Shape shape = shapeCreator.create();
            if (shape.unwrap(row)) {
                stack.push(shape);
            }
        }
        return stack;
    }

    /*

    public List<Shape> unwrap(List<String> rows) {
        List<Shape> shapes = new ArrayList<>();
        for(String row : rows) {
            String[] cols = row.split(";");
            String className = cols[0];
            Optional<Shape> figureOptional = FigureFactory.getFigure(className, canvas, new Point2D.Double(0,0));
            figureOptional.ifPresent(
                figure -> {
                    if(figure instanceof Saveable) {
                        if(((Saveable) figure).unwrap(row)) {
                            shapes.add(figure);
                        }
                    }
                }
            );
        }
        return shapes;
    }
    */
}
