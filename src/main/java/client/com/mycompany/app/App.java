package client.com.mycompany.app;
import client.com.mycompany.app.client.*;
import org.json.JSONObject;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {



    public static void main(String[] args) {
        JSONObject message = new JSONObject();
        JSONObject response;
        message.put("Type","GET");
        message.put("Table","CLIENT");
        message.put("ID",101);

        Client client = new Client();
        client.startConnection("127.0.0.1", 2137);

        response = client.sendMessage(message.toString());
        System.out.println(response);


    }
}
