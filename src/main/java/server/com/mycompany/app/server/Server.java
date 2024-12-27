package server.com.mycompany.app.server;

import java.net.*;
import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;

import server.com.mycompany.app.server.Database.Database;
import org.json.*;
import server.com.mycompany.app.server.Database.Client;
import server.com.mycompany.app.server.Database.Querries;


public class Server implements ServerInterface{

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    JSONObject messageJSON;
    JSONObject response;

    private Database database;
    public void start(int port) {


        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch (IOException e){
            System.out.println("failed start:");
            System.out.println(e);
        }
    }

    public void Listener(){
        String message = new String();
        try{
            message = in.readLine();
        }catch (IOException e){
            e.printStackTrace();
            e.getMessage();
        }

        messageJSON = new JSONObject(message);
        while(!messageJSON.getString("Type").equals("CLOSE")){
            messageHandler(messageJSON);
            try{
                message = in.readLine();
            }catch (IOException e){
                e.printStackTrace();
                e.getMessage();
            }
        }
    }
    void messageHandler(JSONObject msg){

        JSONObject response = new JSONObject();
        String Type = msg.getString("Type");
        switch (Type){

            case "GET_CLIENT":
                Client data = database.getClient(msg.getInt("CLIENT_ID"));
            case "GET_CLIENT_TABLE":
                ArrayList<Client> datalist = database.getClientTable();
                Iterator<Client> iterator = datalist.iterator();
                while(iterator.hasNext()){
                    response = iterator.next().toJSON();
                    response.put("Type","CLIENT");
                    out.println(response.toString());
                }
                response.clear();
                response.put("Type","END");
                break;
            case "UPDATE_CLIENT":
                int i;
                switch (msg.getString("Object")){

                    case "INT":
                        i = database.updateClient(msg.getInt("CLIENT_ID"),msg.getString("Column"),msg.getInt("VALUE"));
                        break;
                    case "STRING":
                        i = database.updateClient(msg.getInt("CLIENT_ID"),msg.getString("Column"),msg.getString("VALUE"));
                        break;
                    case "DATE":

                        i = database.updateClient(msg.getInt("CLIENT_ID"),msg.getString("Column"),Date.valueOf(msg.getString("VALUE")));
                        break;
                }






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
