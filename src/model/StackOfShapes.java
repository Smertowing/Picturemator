package model;

import javafx.scene.canvas.GraphicsContext;
import shapes.Abstracts.*;
import shapes.Interfaces.Selectable;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class StackOfShapes {
    private ArrayList<Shape> arrayOfShapes;
    private int pointer;
    private int maxpointer;

    public StackOfShapes() {
        arrayOfShapes = new ArrayList<>();
        pointer = 0;
        maxpointer = 0;
    }

    public void push(Shape shape) {
        arrayOfShapes.add(pointer++, shape);
        maxpointer = pointer;
    }

    public void pop() {
        pointer = (pointer > 0 ? pointer - 1 : 0);
    }

    public void redo() {
        if (pointer < maxpointer) {
            pointer++;
        }
    }

    public void release(GraphicsContext gc) {
        for (int i = 0; i < pointer; i++) {
            arrayOfShapes.get(i).drawOn(gc);
        }
    }

    public void select(GraphicsContext gc, Point2D.Double point) {
        for (int i = pointer-1; i >= 0; i--) {
            Shape shape = arrayOfShapes.get(i);
            if (shape instanceof Selectable) {
                if (((Selectable) shape).isSelected(point)) {
                    ((Selectable) shape).selectOn(gc);
                    break;
                }
            }

        }
    }


}