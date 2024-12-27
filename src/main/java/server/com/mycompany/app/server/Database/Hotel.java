package server.com.mycompany.app.server.Database;

import org.json.JSONObject;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private String street;
    private int buildingNumber;
    private String postCode;
    private String city;
    private String country;
    private int phoneNumber;
    private int countryCode;

    public Hotel() {
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return street;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
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
        tmp.put("STREET", street);
        tmp.put("BUILDING_NUMBER", buildingNumber);
        tmp.put("POST_CODE", postCode);
        tmp.put("CITY", city);
        tmp.put("COUNTRY", country);
        tmp.put("PHONE_NUMBER", phoneNumber);
        tmp.put("COUNTRY_CODE", countryCode);
        return tmp;
    }
}
