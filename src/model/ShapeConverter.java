package model;

import java.util.ArrayList;
import shapes.Abstracts.*;
import shapes.Interfaces.*;
import shapes.*;

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
