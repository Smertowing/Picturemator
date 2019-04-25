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
                if(shape instanceof SaveLoadable)
                    csv.append(((SaveLoadable) shape).wrap());
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
            try {
                Shape shape = shapeCreator.create();
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
