package server.com.mycompany.app.server.Database;


import java.util.ArrayList;


public class Querries {

    public final int INSERT = 0;
    public final int SELECT = 1;

    public final int TABLE = 2;

    public final int UPDATE = 3;
    public final int DROP = 4;
    public ArrayList<String> Clients = new ArrayList<String>();
    public ArrayList<String> Hotels= new ArrayList<String>();
    public ArrayList<String> Rooms= new ArrayList<String>();

    public Querries(){
        Clients.add("INSERT INTO CLIENT (CLIENT_ID_INCR.NEXTVAL, NAME, LAST_NAME,BIRTH_DATE,NATIONALITY,PHONE_NUMBER,COUNTRY_CODE,EMAIL_ADRESS) VALUES(?,?,?,?,?,?,?,?)");
        Clients.add("SELECT * FROM CLIENT WHERE CLIENT_ID = ?");
        Clients.add("SELECT * FROM CLIENT");
        Clients.add("UPDATE CLIENT SET ? = ? WHERE CLIENT_ID = ?");
        Hotels.add("INSERT INTO hotel (hotel_id_incr.nextval,HOTEL_NAME,street,building_number,post_code,city,country,phone_number,country_code) VALUES(?,?,?,?,?,?,?,?,?)");
        Hotels.add("SELECT * FROM HOTEL WHERE HOTEL_ID = ?");
        Hotels.add("SELECT * FROM HOTEL");
        Hotels.add("UPDATE HOTEL SET ? = ? WHERE HOTEL_ID = ?");
    }





}
