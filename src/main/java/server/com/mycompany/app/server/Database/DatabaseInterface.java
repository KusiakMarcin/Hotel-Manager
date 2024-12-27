package server.com.mycompany.app.server.Database;

public interface DatabaseInterface {
    Client InsertClient();
    void InsertRoom();
    void InsertHotel();

    Client GetClient();

}
