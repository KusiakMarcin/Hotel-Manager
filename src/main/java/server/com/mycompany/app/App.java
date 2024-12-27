package server.com.mycompany.app;
import server.com.mycompany.app.server.*;




/**
 * bruh
 */
public class App {
    public static void main(String[] args) {
        Server server = new Server();
        server.start(2137);
        server.Listener();
        server.stop();


    }
}
