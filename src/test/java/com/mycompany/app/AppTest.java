package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import server.com.mycompany.app.server.Database.*;

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


}
