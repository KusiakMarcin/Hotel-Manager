package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import server.com.mycompany.app.server.Database.*;
import java.sql.Date;

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

}
