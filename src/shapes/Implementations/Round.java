package shapes.Implementations;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;
import shapes.Interfaces.SaveLoadable;
import shapes.Interfaces.Selectable;

public class Round extends Shape implements Selectable, Editable, SaveLoadable {

    public Round() {
        classname = "Round";
    }

    @Override
    public void drawOn(GraphicsContext gc) {
        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.setStroke(borderColor);
        gc.strokeOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side, side);

        gc.setFill(innerColor);
        gc.fillOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side, side);
    }

    @Override
    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.setStroke(Color.BLUE);
        gc.strokeOval((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side, side);

        gc.setLineWidth(tempWidth);
    }

}
