package model;

import shapes.Abstracts.Shape;
import shapes.Interfaces.SaveLoadable;

import java.util.ArrayList;
import java.util.List;

public class ShapeConverter {

    public String wrap(ArrayList<Shape> shapes) {
        StringBuilder csv = new StringBuilder();

        shapes.forEach(
            shape -> {
                if(shape instanceof SaveLoadable)
                    csv.append(((SaveLoadable) shape).wrap());
            }
        );

        return csv.toString();
    }

    public StackOfShapes unwrap(List<String> rows) {
        StackOfShapes stack = new StackOfShapes();
        for(String row : rows) {
            String[] cols = row.split(";");
            String className = cols[0];
            try {
                Shape shape = ShapeCreator.createShape(className);
                if(shape instanceof SaveLoadable)
                    if (((SaveLoadable) shape).unwrap(row)) {
                        stack.push(shape);
                    }
            } catch (Exception e) {
                System.out.print("Corrupted string with name " + className);
            }
        }
        return stack;
    }

}
