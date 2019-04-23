package model;

import javafx.scene.paint.Color;

public class Config {

    private static Config instance = null;
    public Color innerColor, borderColor;

    private Config() {
        innerColor = Color.TRANSPARENT;
        borderColor = Color.BLACK;
    }

    public static Config getInstance() {
        if(instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void setInnerColor(Color innerColor) {
        this.innerColor = innerColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

}
