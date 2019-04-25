package model;

public class Config {

    private static Config instance = null;
    public boolean drawerMode;

    private Config() {
        drawerMode = false;
    }

    public static Config getInstance() {
        if(instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void setDrawerMode(boolean isDrawerMode) {
       drawerMode = isDrawerMode;
    }

}
