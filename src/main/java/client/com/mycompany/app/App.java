package client.com.mycompany.app;
import client.com.mycompany.app.client.*;
import org.json.JSONObject;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Hello world!
 */
public class App extends Application{


    JSONObject message = new JSONObject();
    JSONObject response;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");
        primaryStage.setScene();
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);




    }
}
