package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.*;
import shapes.Interfaces.*;

import java.awt.geom.Point2D;

public class Triangle extends Shape implements Selectable, Editable {
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

    public boolean isSelected(Point2D.Double point) {
        return (((point.x <= alfaPoint.x && point.x >= betaPoint.x) || (point.x >= alfaPoint.x && point.x <= betaPoint.x)) &&
                ((point.x <= alfaPoint.y && point.x >= betaPoint.y) || (point.x >= alfaPoint.y && point.x <= betaPoint.y)));
    }

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

    public void showPointsOn(GraphicsContext gc) {
        gc.setFill(Color.DARKBLUE);
        gc.fillOval(alfaPoint.x-5,alfaPoint.y-5,11,11);
        gc.fillOval(betaPoint.x-5,betaPoint.y-5,11,11);
    }

    public void shift(Double deltaX, Double deltaY) {
        alfaPoint.x += deltaX;
        alfaPoint.y += deltaY;
        betaPoint.x += deltaX;
        betaPoint.y += deltaY;
    }

}
