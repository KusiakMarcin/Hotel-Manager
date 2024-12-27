package server.com.mycompany.app.server.Database;

import org.json.JSONObject;

public class Room {
    int RoomID;
    int RoomNumber;
    int HotelID;
    int RoomType;

    public Room(){
        ;
    }
    public Room(int roomid,int roomnumber,int hotelid,int roomtype){
        RoomID = roomid;
        RoomNumber = roomnumber;
        HotelID = hotelid;
        RoomType = roomtype;

    }
    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setHotelID(int hotelID) {
        HotelID = hotelID;
    }

    public void setRoomType(int roomType) {
        RoomType = roomType;
    }

    public int getRoomID() {
        return RoomID;
    }

    public int getHotelID() {
        return HotelID;
    }

    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getRoomType() {
        return RoomType;
    }
    public JSONObject toJSON(){
        JSONObject tmp = new JSONObject();
        tmp.put("ROOM_ID",RoomID);
        tmp.put("ROOM_NUMBER",RoomNumber);
        tmp.put("HOTEL_ID",HotelID);
        tmp.put("ROOM_TYPE",RoomType);
        return tmp;
    }
}
