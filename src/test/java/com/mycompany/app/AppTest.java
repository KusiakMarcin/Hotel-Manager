package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import server.com.mycompany.app.server.Database.*;

import javax.xml.crypto.Data;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void clientExists() {

        Database database = new Database("admin","admin");

        Guest correctguest = database.getClient(101);


        assertEquals(101,correctguest.getClientID());
    }
    @Test
    public void clientDoesntExists() {

        Database database = new Database("admin","admin");
        Guest guest = database.getClient(1);


        assertEquals(0,guest.getClientID());

    }
}
