package com.liqaa.client.controllers.FXMLcontrollers.components;

import com.liqaa.client.controllers.services.implementations.NotificationServiceImpl;
import com.liqaa.client.util.DateFormatter;
import com.liqaa.shared.models.entities.Notification;
import com.liqaa.shared.models.entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NotificationCard2Controller implements Initializable {
    @FXML
    private Circle senderPhoto;

    @FXML
    private Label notificationTitle;

    @FXML
    private Label notificationDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setNotificationData(Notification notification) throws RemoteException, SQLException {
        User sender = NotificationServiceImpl.getInstance().getNotificationSenderData(notification.getSenderId());
        if(notification.getType().toString().equals("REQUEST_ACCEPTED")) notificationTitle.setText(sender.getDisplayName() + " accepted your invitation request");
        else if(notification.getType().toString().equals("REQUEST_DECLINED")) notificationTitle.setText(sender.getDisplayName() + " declined your invitation request");
        else if(notification.getType().toString().equals("ANNOUNCEMENT")){
            notificationTitle.setText(NotificationServiceImpl.getInstance().getAnnouncementById(notification.getId()).getTitle());
        }
        else if(notification.getType().toString().equals("FRIEND_REQUEST")) notificationTitle.setText(sender.getDisplayName() + " sent you an invitation request");

        notificationDate.setText(DateFormatter.formatDate(notification.getSentAt()));

        Image image;
        if(notification.getType().toString().equals("ANNOUNCEMENT")){
            image = new Image(getClass().getResource("/com/liqaa/client/view/images/announcement.png").toExternalForm());
        }
        else {
            image = new Image(getClass().getResource("/com/liqaa/client/view/images/defaultProfileImage.png").toExternalForm());
            //System.out.println(Arrays.toString(sender.getProfilepicture()) + "\nmmmmmmmmmmm\n");
//            byte[] userPhoto = sender.getProfilepicture();
//            InputStream inputStream = new ByteArrayInputStream(userPhoto);
//            image = new Image(inputStream);
        }
        senderPhoto.setFill(new ImagePattern(image));
        senderPhoto.setStroke(null);
    }

    public void acceptAction(){
        System.out.println("accept button is clicked");
    }

    public void declineAction(){
        System.out.println("decline button is clicked");
    }
}
