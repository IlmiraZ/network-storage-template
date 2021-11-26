package ru.gb.storage.client.fxFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView tableView;
    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }

    public void actionRefresh(ActionEvent actionEvent) {
    }

    public void actionCreateDir(ActionEvent actionEvent) {
    }

    public void actionUploadFile(ActionEvent actionEvent) {
    }

    public void actionExit(ActionEvent actionEvent) {
    }

    public void actionFileDownload(ActionEvent actionEvent) {
    }

    public void actionFileDelete(ActionEvent actionEvent) {
    }

    public void closeConnection() {
    }
}
