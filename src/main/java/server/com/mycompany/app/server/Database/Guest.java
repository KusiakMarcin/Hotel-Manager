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


    public void setClientID(int clientID) {
        this.ClientID = clientID;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.BirthDate = birthDate;
    }

    public void setNationality(String nationality) {
        this.Nationality = nationality;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public void setCountryCode(int countryCode) {
        this.CountryCode = countryCode;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getClientID() {
        return ClientID;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public String getNationality() {
        return Nationality;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public int getCountryCode() {
        return CountryCode;
    }

    public String getEmail() {
        return Email;
    }

}
