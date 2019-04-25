package shapes.Interfaces;

import javafx.scene.paint.Color;

import java.awt.geom.Point2D;

public interface Editable {
    void setAlfaPoint(Point2D.Double alfaPoint);
    void setBetaPoint(Point2D.Double betaPoint);

    void setInnerColor(Color innerColor);
    void setBorderColor(Color borderColor);
}
