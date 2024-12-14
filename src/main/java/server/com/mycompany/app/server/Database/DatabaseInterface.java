package server.com.mycompany.app.server.Database;

public interface DatabaseInterface {
    Guest InsertClient();
    void InsertRoom();
    void InsertHotel();

    Guest GetClient();

}
