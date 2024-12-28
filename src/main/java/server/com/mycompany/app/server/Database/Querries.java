package server.com.mycompany.app.server.Database;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Querries {

    public Map<String,String> Clients = new HashMap<>();

    public Map<String,String> Hotels= new HashMap<>();
    public Map<String,String> Rooms= new HashMap<>();
    public Map<String,String> RoomType = new HashMap<>();

    public Map<String,String> Booking = new HashMap<>();

    public Map<String, String> Guest = new HashMap<>();

    public Querries(){
        Clients.put("INSERT","INSERT INTO CLIENT (CLIENT_ID, NAME, LAST_NAME,BIRTH_DATE,NATIONALITY,PHONE_NUMBER,COUNTRY_CODE,EMAIL_ADRESS) VALUES(CLIENT_ID_INCR.NEXTVAL,?,?,?,?,?,?,?)");
        Clients.put("GET_CLIENT","SELECT * FROM CLIENT WHERE CLIENT_ID = ?");
        Clients.put("GET_TABLE","SELECT * FROM CLIENT");
        Clients.put("UPDATE","UPDATE CLIENT SET # = ? WHERE CLIENT_ID = ?");
        Clients.put("DELETE","DELETE FROM CLIENT WHERE CLIENT_ID = ?");

        Hotels.put("INSERT","INSERT INTO hotel (HOTEL_ID,HOTEL_NAME,street,building_number,post_code,city,country,phone_number,country_code) VALUES(hotel_id_incr.nextval,?,?,?,?,?,?,?,?)");
        Hotels.put("GET_HOTEL","SELECT * FROM HOTEL WHERE HOTEL_ID = ?");
        Hotels.put("GET_TABLE","SELECT * FROM HOTEL");
        Hotels.put("UPDATE","UPDATE HOTEL SET ? = ? WHERE HOTEL_ID = ?");
        Hotels.put("DELETE","DELETE FROM HOTEL WHERE HOTEL_ID = ?");

        Rooms.put("INSERT","INSERT INTO ROOM(ROOM_ID, ROOM_NUMBER, HOTEL_HOTEL_ID,ROOM_TYPE_TYPE_ID) VALUES(room_id_incr.nextval,?,?,?)");
        Rooms.put("GET_ROOM","SELECT * FROM ROOM WHERE ROOM_ID = ?");
        Rooms.put("GET_TABLE","SELECT * FROM ROOM");
        Rooms.put("UPDATE","UPDATE ROOM SET ? = ? WHERE ROOM_ID = ?");
        Rooms.put("DELETE","DELETE FROM ROOM WHERE ROOM_ID = ?");
        Rooms.put("GET_BY_HOTEL","SELECT * FROM ROOM WHERE HOTEL_HOTEL_ID = ?");

        RoomType.put("INSERT","INSERT INTO ROOM_TYPE(TYPE_ID,TYPE_NAME,CAPPACITY) VALUES(room_type_incr.nextval,?,?)");
        RoomType.put("UPDATE","UPDATE SET ? = ? ROOM_TYPE WHERE TYPE_ID = ?");
        RoomType.put("DELETE","DELETE FROM ROOM_TYPE WHERE TYPE_ID=?");
        RoomType.put("GET_TABLE","SELECT * FROM ROOM_TYPE");


        Booking.put("INSERT","INSERT INTO RESERVATION (RESERVATION_ID, CHECK_IN_DATE,CHECK_OUT_DATE,PRESONEL_EMPLOYEE_ID,ROOM_ROOM_ID) VALUES(RESERVATION_ID_INCR.NEXTVAL,?,?,?,?)");
        Booking.put("UPDATE","UPDATE RESERVATION SET ? = ? WHERE RESERVATION_ID = ?");
        Booking.put("DELETE","DELETE FROM RESERVATION WHERE RESERVATION_ID = ?");
        Booking.put("GET_BY_ID","SELECT FROM RESERVATION WHERE RESERVATION_ID =?");

    }





}
