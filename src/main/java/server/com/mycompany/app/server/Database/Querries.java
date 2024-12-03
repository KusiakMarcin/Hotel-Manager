package server.com.mycompany.app.server.Database;


import java.util.ArrayList;


public class Querries {

    public final int INSERT =0;
    public final int SELECT =1;
    public ArrayList<String> Guests= new ArrayList<String>();

    public Querries(){
        Guests.add("INSERT INTO CLIENT (CLIENT_ID, NAME, LAST_NAME,BIRTH_DATE,NATIONALITY,PHONE_NUMBER,COUNTRY_CODE,EMAIL_ADRESS) VALUES(?,?,?,?,?,?,?,?)");
        Guests.add("SELECT * FROM CLIENT");

    }





}
