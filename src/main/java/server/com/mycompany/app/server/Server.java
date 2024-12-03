package server.com.mycompany.app.server;

import java.net.*;
import java.io.*;
import server.com.mycompany.app.server.Database.Database;
import server.com.mycompany.app.server.Database.Guest;


public class Server implements ServerInterface{

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private Database database;
    public void start(int port) {



        try {
            database = new Database("admin","admin");
            var guest = database.getClient();
            System.out.println(guest.getName());

            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            InputStream inputStream = clientSocket.getInputStream();
            ObjectInputStream objectstream = new ObjectInputStream(inputStream);
            String greeting = in.readLine();


            if ("hello server".equals(greeting)) {

                out.println("hello client");
                System.out.println(greeting);
            } else {
                out.println(greeting);
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
