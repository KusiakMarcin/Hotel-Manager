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

    private Database database;
    public void start(int port) {

        var data = new JSONObject();
        data.put("Name","Marcin");
        var data2 = new JSONObject(data.toString());
        try {
            database = new Database("admin","admin");
            var guest = database.getClient();
            System.out.println(guest.getName());

            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String method = in.readLine();


            if ("hello server".equals(method)) {

                    out.println(data.toString());
                    System.out.println(method);
            } else {
                    out.println("failed");
            }




        }catch (IOException e){
            System.out.println("failed start:");
            System.out.println(e);
        }
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
