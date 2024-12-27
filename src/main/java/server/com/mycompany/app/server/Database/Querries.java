package server.com.mycompany.app.server.Database;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Querries {

    public final int INSERT = 0;
    public final int SELECT = 1;

    public final int TABLE = 2;

    public final int UPDATE = 3;
    public final int DELETE = 4;
    public final int ROOMS_IN_HOTEL = 5;
    public ArrayList<String> Clients = new ArrayList<String>();
    public ArrayList<String> Hotels= new ArrayList<String>();
    public ArrayList<String> Rooms= new ArrayList<String>();
    public ArrayList<String> RoomType = new ArrayList<>();

    public Map<String,String> Booking = new HashMap<>();

    public Querries(){
        Clients.add("INSERT INTO CLIENT (CLIENT_ID, NAME, LAST_NAME,BIRTH_DATE,NATIONALITY,PHONE_NUMBER,COUNTRY_CODE,EMAIL_ADRESS) VALUES(CLIENT_ID_INCR.NEXTVAL,?,?,?,?,?,?,?)");
        Clients.add("SELECT * FROM CLIENT WHERE CLIENT_ID = ?");
        Clients.add("SELECT * FROM CLIENT");
        Clients.add("UPDATE CLIENT SET ? = ? WHERE CLIENT_ID = ?");
        Clients.add("DELETE FROM CLIENT WHERE CLIENT_ID = ?");

        Hotels.add("INSERT INTO hotel (HOTEL_ID,HOTEL_NAME,street,building_number,post_code,city,country,phone_number,country_code) VALUES(hotel_id_incr.nextval,?,?,?,?,?,?,?,?)");
        Hotels.add("SELECT * FROM HOTEL WHERE HOTEL_ID = ?");
        Hotels.add("SELECT * FROM HOTEL");
        Hotels.add("UPDATE HOTEL SET ? = ? WHERE HOTEL_ID = ?");
        Hotels.add("DELETE FROM HOTEL WHERE HOTEL_ID = ?");

        Rooms.add("INSERT INTO ROOM(ROOM_ID, ROOM_NUMBER, HOTEL_HOTEL_ID,ROOM_TYPE_TYPE_ID) VALUES(room_id_incr.nextval,?,?,?)");
        Rooms.add("SELECT * FROM ROOM WHERE ROOM_ID = ?");
        Rooms.add("SELECT *FROM ROOM");
        Rooms.add("UPDATE ROOM SET ? = ? WHERE ROOM_ID = ?");
        Rooms.add("DELETE FROM ROOM WHERE ROOM_ID = ?");
        Rooms.add("SELECT * FROM ROOM WHERE HOTEL_HOTEL_ID = ?");

        RoomType.add("INSERT INTO ROOM_TYPE(TYPE_ID,TYPE_NAME,CAPPACITY) VALUES(room_type_incr.nextval,?,?)");

        Booking.put("INSERT","INSERT INTO RESERVATION (RESERVATION_ID, CHECK_IN_DATE,CHECK_OUT_DATE,PRESONEL_EMPLOYEE_ID,ROOM_ROOM_ID) VALUES(RESERVATION_ID_INCR.NEXTVAL,?,?,?,?)");

    }





}
