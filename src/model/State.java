package model;

import java.awt.geom.Point2D;
import shapes.Abstracts.*;

public class State {

    private static State instance = null;
    private State() {
        drawerMode = false;
    }

    public boolean drawerMode;
    public Shape editingShape = null;
    public Point2D.Double selectionPoint = null;

    public static State getInstance() {
        if(instance == null) {
            instance = new State();
        }
        return instance;
    }

}