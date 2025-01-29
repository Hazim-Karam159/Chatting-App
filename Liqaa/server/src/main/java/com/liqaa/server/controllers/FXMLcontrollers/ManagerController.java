package com.liqaa.server.controllers.FXMLcontrollers;

import com.liqaa.server.Main;
import com.liqaa.server.util.FilePaths;
import com.liqaa.server.util.SceneManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ManagerController {
    @javafx.fxml.FXML
    private Pane statisticsButton;
    @javafx.fxml.FXML
    private Pane announcementsButton;
    @javafx.fxml.FXML
    private Pane managerButton;
    @javafx.fxml.FXML
    private Button resetPasswordButton;
    @javafx.fxml.FXML
    private TableView usersDataTable;
    @javafx.fxml.FXML
    private ImageView toggleServiceButton;
    @javafx.fxml.FXML
    private Pane logoutButton;

    private boolean serviceStatus = false;

    @javafx.fxml.FXML
    public void resetPassword(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logout(Event event) {

    }

    @javafx.fxml.FXML
    public void switchToStatistics(Event event) {
        try {
            SceneManager.getInstance().switchScene(new Scene(FXMLLoader.load(Main.class.getResource(FilePaths.STATISTICS_SCREEN_FXML))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void toggleService(Event event)
    {
        serviceStatus = !serviceStatus;
        String imagePath = "images//password1.png";
   }

    @javafx.fxml.FXML
    public void switchToAnnouncements(Event event) {
        try {
            SceneManager.getInstance().switchScene(new Scene(FXMLLoader.load(Main.class.getResource(FilePaths.ANNOUNCEMENTS_SCREEN_FXML))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}