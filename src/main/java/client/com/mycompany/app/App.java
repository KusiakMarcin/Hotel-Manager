package client.com.mycompany.app;
import client.com.mycompany.app.client.*;
import org.json.JSONObject;

import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application{

    Client client  = new Client();
    JSONObject message = new JSONObject();
    JSONObject response;
    @Override
    public void start(Stage primaryStage) throws Exception {
        getClientTable();
        primaryStage.setTitle("My First JavaFX App");

        primaryStage.show();
    }

    public void getClientTable(){

        message.put("Type","GET");
        message.put("Table","CLIENT");
        message.put("ID",101);
        client.startConnection("127.0.0.1", 2137);

        response = client.sendMessage(message.toString());
        System.out.println(response);
    }
    public static void main(String[] args) {
        Application.launch(args);


    }
}
