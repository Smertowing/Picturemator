package shapes.Implementations;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.SaveLoadable;
import shapes.Interfaces.Selectable;

public class Rectangle extends Shape implements Selectable, SaveLoadable {

    public Rectangle() {
        classname = "Rectangle";
    }

    @Override
    public void drawOn(GraphicsContext gc) {

        gc.setStroke(borderColor);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));

        gc.setFill(innerColor);
        gc.fillRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));
    }

    @Override
    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        gc.setStroke(Color.BLUE);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                Math.abs(betaPoint.x - alfaPoint.x),
                Math.abs(betaPoint.y - alfaPoint.y));

        gc.setLineWidth(tempWidth);
    }

}
