package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Abstracts.Shape;
import shapes.Interfaces.Editable;

public class IdealTriangle extends Shape implements Editable {
    @Override
    public void drawOn(GraphicsContext gc) {
        double width = Math.abs(betaPoint.x - alfaPoint.x) * (betaPoint.x < alfaPoint.x ? -1 : 1);
        double height = Math.abs(betaPoint.y - alfaPoint.y) * (betaPoint.y < alfaPoint.y ? -1 : 1);

        gc.setStroke(borderColor);
        gc.strokePolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);

        gc.setFill(innerColor);
        gc.fillPolygon(new double[]{alfaPoint.x, alfaPoint.x + width, alfaPoint.x},
                new double[]{alfaPoint.y, alfaPoint.y + height, alfaPoint.y + height}, 3);
    }

    public IdealTriangle(Color borderColor, Color innerColor) {
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
}
