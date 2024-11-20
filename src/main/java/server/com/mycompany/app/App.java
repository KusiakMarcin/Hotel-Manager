package server.com.mycompany.app;
import server.com.mycompany.app.server.*;

import java.util.Scanner;

/**
 * bruh
 */
public class App {
    public static void main(String[] args) {
        Server server = new Server();
        server.start(6666);
        System.out.println("type 1 to exit");
        var q = new Scanner(System.in);
        while(true){
            if(q.nextInt()==1);
            server.stop();
            break;
        }
    }
}
