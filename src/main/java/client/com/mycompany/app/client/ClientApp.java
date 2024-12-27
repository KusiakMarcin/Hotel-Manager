package client.com.mycompany.app.client;
import org.json.JSONObject;

import java.net.*;
import java.io.*;


public class ClientApp {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private JSONObject message= new JSONObject();



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
