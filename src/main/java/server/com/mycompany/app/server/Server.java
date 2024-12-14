package server.com.mycompany.app.server;

import java.net.*;
import java.io.*;
import server.com.mycompany.app.server.Database.Database;
import org.json.*;
import server.com.mycompany.app.server.Database.Guest;


public class Server implements ServerInterface{

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    JSONObject messageJSON;
    JSONObject response;

    private Database database;
    public void start(int port) {

        var data = new JSONObject();
        data.put("Name","Marcin");
        var data2 = new JSONObject(data.toString());
        try {

            database = new Database("admin","admin");
            var guest = database.getClient(101);
            System.out.println(guest.getClientID());

            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            messageJSON = new JSONObject(message);
            while(!messageJSON.getString("Type").equals("CLOSE")){
                response = messageHandler(messageJSON);
                out.println(response.toString());
                message = in.readLine();
            }

            stop();


        }catch (IOException e){
            System.out.println("failed start:");
            System.out.println(e);
        }
    }


    JSONObject messageHandler(JSONObject msg){
        JSONObject tmp = new JSONObject();
        Guest guestBuffer = new Guest();
        if(msg.getString("Type").equals("GET")){
            guestBuffer = database.getClient(msg.getInt("PrimaryKey"));

        }

        return tmp;
    }
    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e ){
            System.out.println("failed close:");
            System.out.println(e);
        }
    }

}
