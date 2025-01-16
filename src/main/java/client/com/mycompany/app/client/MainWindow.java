package client.com.mycompany.app.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class MainWindow {

    //private FXMLLoader;
    @FXML
    private AnchorPane mainContent;

    @FXML
    private void showHotelsView() {
        loadView("client/com/mycompany/app/HotelsView.fxml");
    }

    @FXML
    private void showClientsView() {
        loadView("client/com/mycompany/app/ClientsView.fxml");
    }

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/ClientsView.fxml"));
            AnchorPane view = loader.load();
            mainContent.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
