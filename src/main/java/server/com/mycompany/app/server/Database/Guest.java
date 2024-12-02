package server.com.mycompany.app.server.Database;

import java.sql.Date;

public class Guest {
    private int ClientID;
    private String Name;
    private String LastName;

    private Date BirthDate;
    private String Nationality;
    private int PhoneNumber;
    private int CountryCode;
    private String Email;

    public int GetClientID(){
        return ClientID;
    }
}
