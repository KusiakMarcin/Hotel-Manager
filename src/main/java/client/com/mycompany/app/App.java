package client.com.mycompany.app;
import client.com.mycompany.app.client.*;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Client client = new Client();
        client.startConnection("127.0.0.1", 2137);

//            Scanner scaner = new Scanner(System.in);
//            String message = scaner.next();
        String response = client.sendMessage("hello server");
        System.out.println(response);


    }
}
