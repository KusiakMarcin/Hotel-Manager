package server.com.mycompany.app.server.Database;


import java.util.ArrayList;


public class Querries {

    public final int INSERT = 0;
    public final int SELECT = 1;

    public final int TABLE = 2;

    public final int UPDATE = 3;
    public ArrayList<String> Guests= new ArrayList<String>();
    public ArrayList<String> Hotels= new ArrayList<String>();
    public ArrayList<String> Rooms= new ArrayList<String>();

    public Querries(){
        Guests.add("INSERT INTO CLIENT (CLIENT_ID_INCR.NEXTVAL, NAME, LAST_NAME,BIRTH_DATE,NATIONALITY,PHONE_NUMBER,COUNTRY_CODE,EMAIL_ADRESS) VALUES(?,?,?,?,?,?,?,?)");
        Guests.add("SELECT * FROM CLIENT WHERE CLIENT_ID = ?");
        Guests.add("SELECT * FROM CLIENT");
        Guests.add("UPDATE CLIENT SET ? = ? WHERE CLIENT_ID = ?");

    }





}
