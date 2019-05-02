package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.*;
import shapes.Interfaces.*;

import java.awt.geom.Point2D;

public class Square extends Shape implements Selectable, Editable, SaveLoadable {

    public Square() {
        classname = "Square";
    }

    @Override
    public void drawOn(GraphicsContext gc) {
        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.setStroke(borderColor);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side,
                side);

        gc.setFill(innerColor);
        gc.fillRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side,
                side);
    }

    @Override
    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        double side = (Math.abs(betaPoint.x - alfaPoint.x) < Math.abs(betaPoint.y - alfaPoint.y) ? Math.abs(betaPoint.x - alfaPoint.x) : Math.abs(betaPoint.y - alfaPoint.y));

        gc.setStroke(Color.BLUE);
        gc.strokeRect((alfaPoint.x < betaPoint.x ? alfaPoint.x : betaPoint.x),
                (alfaPoint.y < betaPoint.y ? alfaPoint.y : betaPoint.y),
                side,
                side);

        gc.setLineWidth(tempWidth);
    }

}
