package eu.oodev;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Window {

    public void start(int w, int h, String htmlPath) {

        Platform.startup(() -> {
            Stage stage = new Stage();

            Path path = Paths.get(htmlPath);

            WebView webView = new WebView();


            String htmlContent = null;
            try {
                htmlContent = Files.readString(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ;
            webView.getEngine().loadContent(htmlContent);

            Scene scene = new Scene(webView, w, h);

            stage.setTitle("ONT");
            stage.getIcons().add(new javafx.scene.image.Image(
                    getClass().getResourceAsStream("/icon.png")
            ));
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        });
    }
}
