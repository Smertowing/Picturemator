package model;

import shapes.Abstracts.Shape;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ShapeCreator {

    private static String libsPath = "libs";
    private static List<Class<Shape>> shapeClasses = getShapeClasses();

    private static List<Class<Shape>> getShapeClasses() {

        List<Class<Shape>> shapes = new ArrayList<>();
        File folder = new File(Paths.get(libsPath).toAbsolutePath().toString());
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) return shapes;

        for (File likelyFile : listOfFiles) {
            if (likelyFile.isFile()) {
                try {
                    JarFile jarFile = new JarFile(likelyFile.getAbsolutePath());
                    Enumeration<JarEntry> enumer = jarFile.entries();

                    URL[] urls = {new URL("jar:file:" + likelyFile.getAbsolutePath() + "!/")};
                    URLClassLoader classLoader = URLClassLoader.newInstance(urls);

                    while (enumer.hasMoreElements()) {
                        JarEntry jarEntry = enumer.nextElement();
                        if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
                            continue;
                        }

                        String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
                        className = className.replace('/', '.');

                        Class instance = classLoader.loadClass(className);

                        if (Shape.class.isAssignableFrom(instance)) {
                            shapes.add((Class<Shape>) instance);
                        }


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return shapes;
    }

    public static Shape createShape(String name) {
        for(Class<Shape> shapeClass: shapeClasses) {
            if (shapeClass.getName().endsWith(name)) {
                try {
                    Constructor constructor = shapeClass.getConstructor();
                    return (Shape) constructor.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
        }
        throw new RuntimeException();
    }

}
