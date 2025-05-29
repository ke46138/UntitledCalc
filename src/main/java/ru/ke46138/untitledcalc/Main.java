package ru.ke46138.untitledcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/fonts/DSEG14Modern-Italic.ttf"), 64);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 500);
        stage.setTitle("UntitledCalc");
        stage.setScene(scene);

        // Запрет изменения размеров окна
        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}