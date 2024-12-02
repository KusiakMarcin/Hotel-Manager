package client.com.mycompany.app.client;
import java.net.*;
import java.io.*;
import java.nio.channels.ScatteringByteChannel;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;


    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputStream = clientSocket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
        }
        catch (IOException e){
            System.out.println(e);
        }
        }

    public String sendMessage(String msg) {
        out.println(msg);

        try {
            String resp = in.readLine();
            return resp;
        }
        catch (IOException e){

            return "failed to connect ";
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
