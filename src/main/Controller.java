package main;

import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import model.factories.ShapeCreator;
import model.*;
import shapes.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import shapes.Abstracts.*;

import java.awt.geom.Point2D;

public class Controller {
    @FXML
    private Canvas mainCanvas;
    @FXML
    private ColorPicker innerColorPicker, borderColorPicker;
    private Shape currentShape;
    private StackOfShapes stack = new StackOfShapes();
    private ShapeCreator shapeCreator = new ShapeCreator("Line");
    private GraphicsContext gc;

    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        gc.setLineWidth(3);
        gc.strokeRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());

        innerColorPicker.setValue(Color.TRANSPARENT);
        borderColorPicker.setValue(Color.BLACK);
    }

    // Drawing on Canvas
    public void mousePressed(MouseEvent mouseEvent) {
        currentShape = shapeCreator.create(borderColorPicker.getValue(), innerColorPicker.getValue());
        currentShape.setAlfaPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        currentShape.setBetaPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
        clearCanvas(null);
        stack.drawOn(gc);
        currentShape.drawOn(gc);

    }

    public void mouseReleased(MouseEvent mouseEvent) {
        currentShape.setBetaPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
        currentShape.drawOn(gc);
        stack.push(currentShape);
        currentShape = null;
    }

    public void undoBtnWasClicked() {
        clearCanvas(null);
        stack.pop();
        stack.drawOn(gc);
    }

    public void redoBtnWasClicked() {
        clearCanvas(null);
        stack.redo();
        stack.drawOn(gc);
    }

    public void shapeBtnWasClicked(MouseEvent event) {
        shapeCreator.setCurrentFactory(((Button) event.getSource()).getId());
    }

    public void clearCanvas(MouseEvent event) {
        gc.clearRect(1, 1, mainCanvas.getWidth() - 2, mainCanvas.getHeight() - 2);
        if (event != null) {
            stack = new StackOfShapes();
        }
    }
}
