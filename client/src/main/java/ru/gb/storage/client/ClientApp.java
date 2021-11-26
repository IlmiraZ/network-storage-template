package ru.gb.storage.client;

import ru.gb.storage.client.fxFiles.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientApp extends Application {
    private static final String HOST = "localhost";
    private static final int PORT = 9000;
    private static MainController controller;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NetworkProperties.setHost(HOST);
        NetworkProperties.setPort(PORT);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/main.fxml"));
        Parent root = loader.load();
        stage.setTitle("Network Storage");
        stage.setScene(new Scene(root, 500, 400));
        stage.setOnCloseRequest(event -> {
            controller = loader.getController();
            controller.closeConnection();
            System.exit(0);
        });
        stage.show();
    }
}
