package client.com.mycompany.app.client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import org.json.JSONObject;


import java.net.*;
import java.io.*;


public class Client{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private FXMLLoader loader;
    private String message;

    private String response;


    public Client(String ip,int port){

        startConnection(ip,port);
    }
    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        }
        catch (IOException e){
            System.out.println(e);
        }
        }
    public void Listener(){


    }
    public JSONObject sendMessage(String msg) {
        out.println(msg);
        JSONObject data;
        try {
            String resp = in.readLine();
            data = new JSONObject(resp);
            return data;
        }
        catch (IOException e){
            System.out.println(e);
            data = new JSONObject();
            data.put("Type","Error");
            return data;
        }

    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }



}
