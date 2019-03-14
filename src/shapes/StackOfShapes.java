package shapes;

import javafx.scene.canvas.GraphicsContext;

public class StackOfShapes implements Drawable {
    private Shape[] arrayOfShapes;
    private int pointer;
    private int maxpointer;

    public StackOfShapes() {
        arrayOfShapes = new Shape[256];
        pointer = 0;
        maxpointer = 0;
    }

    public void push(Shape shape) {
        arrayOfShapes[pointer++] = shape;
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
            arrayOfShapes[i].drawOn(gc);
        }
    }
}