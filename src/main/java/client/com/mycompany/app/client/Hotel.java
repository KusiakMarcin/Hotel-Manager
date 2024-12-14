package client.com.mycompany.app.client;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private String street;
    private String buildingNumber;
    private String postCode;
    private String city;
    private String country;
    private String phoneNumber;
    private String countryCode;

    public Hotel(int hotelId, String hotelName, String street, String buildingNumber, String postCode,
                 String city, String country, String phoneNumber, String countryCode) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
    }

    // Gettery i settery
    public int getHotelId() { return hotelId; }
    public void setHotelId(int hotelId) { this.hotelId = hotelId; }
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getBuildingNumber() { return buildingNumber; }
    public void setBuildingNumber(String buildingNumber) { this.buildingNumber = buildingNumber; }
    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
}
