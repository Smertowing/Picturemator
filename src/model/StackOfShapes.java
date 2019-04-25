package model;

import javafx.scene.canvas.GraphicsContext;
import shapes.Interfaces.Drawable;
import shapes.Abstracts.*;

import java.util.ArrayList;

public class StackOfShapes implements Drawable {
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

    @Override
    public void drawOn(GraphicsContext gc) {
        for (int i = 0; i < pointer; i++) {
            arrayOfShapes.get(i).drawOn(gc);
        }
    }
}