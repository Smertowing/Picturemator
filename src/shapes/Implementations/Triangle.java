package shapes.Implementations;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;
import shapes.Interfaces.SaveLoadable;
import shapes.Interfaces.Selectable;

public class Triangle extends Shape implements Selectable, Editable, SaveLoadable {

    public Triangle() {
        classname = "Triangle";
    }

    @Override
    public void drawOn(GraphicsContext gc) {
        double width = Math.abs(betaPoint.x - alfaPoint.x);
        double height = Math.abs(betaPoint.y - alfaPoint.y) * (betaPoint.y < alfaPoint.y ? -1 : 1);

        gc.setStroke(borderColor);
        gc.strokePolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x - width},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);

        gc.setFill(innerColor);
        gc.fillPolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x - width},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);
    }

    @Override
    public void selectOn(GraphicsContext gc) {
        double tempWidth = gc.getLineWidth();
        gc.setLineWidth(6);

        double width = Math.abs(betaPoint.x - alfaPoint.x);
        double height = Math.abs(betaPoint.y - alfaPoint.y) * (betaPoint.y < alfaPoint.y ? -1 : 1);

        gc.setStroke(Color.BLUE);
        gc.strokePolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x - width},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);

        gc.setLineWidth(tempWidth);
    }

}
