package server.com.mycompany.app.server.Database;

import org.json.JSONObject;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private String Street;
    private int buildingNumber;
    private String postCode;
    private String City;
    private String Country;
    private int phoneNumber;
    private int countryCode;

    public Hotel(){
        ;
    }
    public Hotel(int hotelid,String hotelname,String street,int buildingnumber,String postcode,String city,String country,int phone,int countrycode) {
        hotelId = hotelid;
        hotelName = hotelname;
        Street = street;
        buildingNumber = buildingnumber;
        postCode = postcode;
        City = city;
        Country = country;
        phoneNumber = phone;
        countryCode = countrycode;

    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getStreet() {
        return Street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public JSONObject toJSON() {
        JSONObject tmp = new JSONObject();
        tmp.put("HOTEL_ID", hotelId);
        tmp.put("HOTEL_NAME", hotelName);
        tmp.put("STREET", Street);
        tmp.put("BUILDING_NUMBER", buildingNumber);
        tmp.put("POST_CODE", postCode);
        tmp.put("CITY", City);
        tmp.put("COUNTRY", Country);
        tmp.put("PHONE_NUMBER", phoneNumber);
        tmp.put("COUNTRY_CODE", countryCode);
        return tmp;
    }
}
