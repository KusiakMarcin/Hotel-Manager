package client.com.mycompany.app.client;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;



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

    public String sendMessage(String msg) {
        out.println(msg);

        try {
            String resp = in.readLine();
            var data = new JSONObject(resp);
            System.out.println(data.getString("Name"));
        }
        catch (IOException e){

            return "failed to connect ";
        }
        return "connectedidk";
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
