package client.com.mycompany.app;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.json.JSONObject;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Hello world!
 */
public class App extends Application{


    JSONObject message = new JSONObject();
    JSONObject response;
    FXMLLoader loader ;


    @FXML
    private Button showHotels;

    @FXML
    private Button showClients;

    @FXML
    private Button showBookings;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        loader = new FXMLLoader(getClass().getResource("BookingView.fxml"));
        Parent root = loader.load();
        System.out.println(loader.getLocation());
        //primaryStage.setScene(root);
        primaryStage.show();
    }

//    @FXML
//    private Scene showHotelsView(){
//        loader = new FXMLLoader(getClass().getResource("../../../../../resources/HotelsView.fxml"));
//        try {
//
//        }catch (IOException e ){
//            e.printStackTrace();
//        }
//        return new Scene(root);
//    }
//    @FXML
//    public Scene showClientsView(){
//        loader = new FXMLLoader(getClass().getResource("client/com/mycompany/app/client/ClientsView.fxml"));
//        try {
//            root = loader.load();
//        }catch (IOException e ){
//            e.printStackTrace();
//        }
//        return new Scene(root);
//    }
//    @FXML
//    private Scene showBookingView(){
//        loader = new FXMLLoader(getClass().getResource("../../../../../resources/BookingView.fxml"));
//        try {
//            root = loader.load();
//        }catch (IOException e ){
//            e.printStackTrace();
//        }
//        return new Scene(root);
//    }


    public static void main(String[] args) {
        Application.launch(args);




    }
}
