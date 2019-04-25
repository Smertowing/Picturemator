package main;

import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import model.ShapeCreator;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import shapes.Abstracts.*;
import shapes.Interfaces.*;

import java.awt.geom.Point2D;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    @FXML
    private Canvas mainCanvas;
    @FXML
    private ColorPicker innerColorPicker, borderColorPicker;
    private Shape currentShape;
    private StackOfShapes stack = new StackOfShapes();
    private ShapeCreator shapeCreator = new ShapeCreator("Line");
    private GraphicsContext gc;
    private State state = State.getInstance();

    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        gc.setLineWidth(5);
        gc.strokeRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());

        innerColorPicker.setValue(Color.TRANSPARENT);
        borderColorPicker.setValue(Color.BLACK);
    }

    // Drawing on Canvas
    public void mousePressed(MouseEvent mouseEvent) {
        Point2D.Double point = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
        if (state.drawerMode) {
            currentShape = shapeCreator.create();
            currentShape.setBorderColor(borderColorPicker.getValue());
            currentShape.setInnerColor(innerColorPicker.getValue());
            currentShape.setAlfaPoint(point);
        } else {
            clearCanvas(null);
            stack.release(gc);
            stack.select(gc, point);
        }
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        Point2D.Double point = new Point2D.Double(mouseEvent.getX(), mouseEvent.getY());
        if (!state.drawerMode) {
            if (state.editingShape != null) {
                if (Math.abs(state.editingShape.alfaPoint.x - state.selectionPoint.x) < 10 && Math.abs(state.editingShape.alfaPoint.y - state.selectionPoint.y) < 10) {
                    state.editingShape.setAlfaPoint(point);
                } else if (Math.abs(state.editingShape.betaPoint.x - state.selectionPoint.x) < 10 && Math.abs(state.editingShape.betaPoint.y - state.selectionPoint.y) < 10) {
                    state.editingShape.setBetaPoint(point);
                } else {
                    ((Editable) state.editingShape).shift(point.x - state.selectionPoint.x, point.y - state.selectionPoint.y);
                }
                clearCanvas(null);
                stack.release(gc);
                ((Selectable) state.editingShape).selectOn(gc);
                ((Editable) state.editingShape).showPointsOn(gc);
                state.selectionPoint = point;
            }
        } else {
            clearCanvas(null);
            stack.release(gc);
            currentShape.setBetaPoint(point);
            currentShape.drawOn(gc);
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        if (state.drawerMode) {
            currentShape.setBetaPoint(new Point2D.Double(mouseEvent.getX(), mouseEvent.getY()));
            currentShape.drawOn(gc);
            stack.push(currentShape);
            currentShape = null;
        }
    }

    public void undoBtnWasClicked() {
        clearCanvas(null);
        stack.pop();
        stack.release(gc);
    }

    public void redoBtnWasClicked() {
        clearCanvas(null);
        stack.redo();
        stack.release(gc);
    }

    public void shapeBtnWasClicked(MouseEvent event) {
        clearCanvas(null);
        stack.release(gc);
        state.drawerMode = true;
        shapeCreator.setCurrentFactory(((Button) event.getSource()).getId());
    }

    public void selectModeClicked() {
        clearCanvas(null);
        stack.release(gc);
        state.drawerMode = false;
    }

    private void clearCanvas(MouseEvent event) {
        gc.clearRect(1, 1, mainCanvas.getWidth() - 2, mainCanvas.getHeight() - 2);
        if (event != null) {
            stack = new StackOfShapes();
        }
    }

    public void onHidingColorPicker() {
        if (!state.drawerMode) {
            state.editingShape.setBorderColor(borderColorPicker.getValue());
            state.editingShape.setInnerColor(innerColorPicker.getValue());
        }
    }

    private void alert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error:");
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }

    public void saveAsClicked() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Save");
        File selectedDirectory = directoryChooser.showDialog(null);
        if (selectedDirectory != null) {
            String directorypath = selectedDirectory.getPath();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            String format = currentDate+".txt";

            String path = directorypath+"/"+format;

            File newfile = new File(path);
            try {
                if (newfile.createNewFile()) {
                    ArrayList<Shape> shapes = stack.getList();

                    ShapeConverter converter = new ShapeConverter();
                    String wrapedShapes = converter.wrap(shapes);
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                        bw.write(wrapedShapes);
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            } catch (IOException e) {
                alert(new RuntimeException("Invalid path"));
            } catch (Exception e) {
                alert(new Exception(e));
            }
        }
    }

    public void openClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                List<String> rows = Files.readAllLines(Paths.get(file.getPath()));

                ShapeConverter converter = new ShapeConverter();

                stack = converter.unwrap(rows);

                if(stack.isEmpty()) {
                    alert(new RuntimeException("Invalid or empty file"));
                } else {
                    clearCanvas(null);
                    stack.release(gc);
                }
            } catch (IOException e) {
                alert(new RuntimeException("Invalid or empty file"));
            } catch (Exception e) {
                alert(new Exception(e));
            }
        }
    }
}
