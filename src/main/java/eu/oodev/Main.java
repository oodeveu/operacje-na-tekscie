package eu.oodev;

import java.awt.Toolkit;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        window.start((int)width/2,(int)height/2,"src/main/resources/index.html");
    }
}