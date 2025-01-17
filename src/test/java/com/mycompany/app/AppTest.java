package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import oracle.sql.DATE;
import org.junit.jupiter.api.Test;
import server.com.mycompany.app.server.Database.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void clientExists() {

        Database database = new Database();

        Client correctguest = database.getClient(101);


        assertEquals(101,correctguest.getClientID());
    }
    @Test
    public void clientDoesntExists() {

        Database database = new Database();
        Client client = database.getClient(1);


        assertEquals(0, client.getClientID());

    }

    @Test
    public void InsertClientTest(){
        Date birthDate = new Date(85, 6, 15);

        Client client = new Client(
                1,
                "Emma",
                "Smith",
                birthDate,
                "Finnish",
                987654321,
                58,
                "emma.smith@example.com"
        );
        Database database = new Database();
        int a = database.InsertClient(client);
        assertEquals(0,a);
    }
    @Test
    public void InsertHotelTest(){
        Hotel hotel = new Hotel(101,
                "Sunset Inn",
                "Main St",
                12,
                "12345-678",
                "Springfield",
                "USA",
                123456789,
                1);

        Database database = new Database();
        int a = database.InsertHotel(hotel);
        assertEquals(0,a);
    }

    @Test
    public void GetRoomTableTest(){
        Database database = new Database();
        ArrayList<Room> data = database.getRoomTable();
        assertTrue(!data.isEmpty());
    }

    @Test
    public void GetClientTableTest(){
        Database database = new Database();
        ArrayList<Client> data = database.getClientTable();
        assertTrue(!data.isEmpty());
    }

    @Test
    public void TestUpdateStringClient(){
        Database database = new Database();
        assertEquals(0,database.updateClient(7,"NAME","Aeron"));
    }

    @Test
    public void TestUpdateDateClient(){
        Date date = new Date(1999,12,21);
        Database database = new Database();
        assertEquals(0,database.updateClient(7,"BIRTH_DATE",date));
    }
    @Test
    public void TestDelete(){
        Database database = new Database();
        assertEquals(0,database.deleteClient(4));
    }
}
