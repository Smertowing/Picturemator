package model;

import javafx.scene.canvas.GraphicsContext;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;
import shapes.Interfaces.Selectable;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class StackOfShapes {

    private ArrayList<Shape> arrayOfShapes;
    private State state = State.getInstance();
    private int pointer;
    private int maxPointer;

    public StackOfShapes() {
        arrayOfShapes = new ArrayList<>();
        pointer = 0;
        maxPointer = 0;
    }

    public boolean isEmpty() {
        return arrayOfShapes.isEmpty();
    }


    public void push(Shape shape) {
        arrayOfShapes.add(pointer++, shape);
        maxPointer = pointer;
    }

    public void pop() {
        pointer = (pointer > 0 ? pointer - 1 : 0);
    }

    public void redo() {
        if (pointer < maxPointer) pointer++;
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
                    if (shape instanceof Editable) {
                        ((Editable) shape).showPointsOn(gc);
                        state.editingShape = shape;
                        state.selectionPoint = point;
                    } else {
                        state.editingShape = null;
                        state.selectionPoint = null;
                    }
                    return;
                }
            }
        }
        state.editingShape = null;
        state.selectionPoint = null;
    }

    public ArrayList<Shape> getList() {
        ArrayList<Shape> array = new ArrayList<>();
        for (int i = 0; i < pointer; i++) {
            array.add(i, arrayOfShapes.get(i));
        }
        return array;
    }

}