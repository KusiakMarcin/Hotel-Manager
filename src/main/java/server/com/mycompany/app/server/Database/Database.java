package server.com.mycompany.app.server.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
public class Database {
    protected String url = "jdbc:oracle:thin:@localhost:1521:xe";
    protected Connection con;
    protected Properties props = new Properties();
    protected Querries querry = new Querries();

    public Database() {

        props.put("user", "SYS");
        props.put("password", "admin");
        props.put("internal_logon", "SYSDBA");
        try {

            con = DriverManager.getConnection(url, props);
            System.out.println("Connected Database");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
    public Client getClient(int primaryKey){

        String a = querry.Clients.get(querry.SELECT);
        var tmp = new Client();
        try {
            PreparedStatement stmt = con.prepareStatement(a, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1,primaryKey);
            ResultSet result = stmt.executeQuery();

            result.first();
            retriveClientData(tmp,result);

        }catch (SQLException e){
            e.printStackTrace();




        }
        return tmp;

    }
    public ArrayList<Client> getClientTable(){
        String Querry = querry.Clients.get(querry.TABLE);
        var tmp = new Client();
        ArrayList<Client> dataList = new ArrayList<Client>();
        try{
            PreparedStatement stmt = con.prepareStatement(Querry,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet result =stmt.executeQuery();
            if(result.first()) {
                while (result.isAfterLast()){
                    retriveClientData(tmp,result);
                    dataList.add(tmp);
                    result.next();
                }
            }else{
                System.out.println("result.first() false");
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return dataList;
    }
    public void retriveClientData(Client client, ResultSet data){
        try {
            client.setClientID(data.getInt("CLIENT_ID"));
            client.setName(data.getString("NAME"));
            client.setLastName(data.getString("LAST_NAME"));
            client.setBirthDate(data.getDate("BIRTH_DATE"));
            client.setNationality(data.getString("NATIONALITY"));
            client.setPhoneNumber(data.getInt("PHONE_NUMBER"));
            client.setCountryCode(data.getInt("COUNTRY_CODE"));
            client.setEmail(data.getString("EMAIL_ADRESS"));
        }catch (SQLException e ){
            e.printStackTrace();

        }

    }

    public void retrieveHotelData(Hotel hotel, ResultSet data) {
        try {
            hotel.setHotelId(data.getInt("HOTEL_ID"));
            hotel.setHotelName(data.getString("HOTEL_NAME"));
            hotel.setStreet(data.getString("STREET"));
            hotel.setBuildingNumber(data.getInt("BUILDING_NUMBER"));
            hotel.setPostCode(data.getString("POST_CODE"));
            hotel.setCity(data.getString("CITY"));
            hotel.setCountry(data.getString("COUNTRY"));
            hotel.setPhoneNumber(data.getInt("PHONE_NUMBER"));
            hotel.setCountryCode(data.getInt("COUNTRY_CODE"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public int updateClient(int primaryKey,String column,Date value){
        String Querry = querry.Clients.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,column);
            stmt.setDate(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    public int updateClient(int primaryKey,String column,String value){
        String Querry = querry.Clients.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,column);
            stmt.setString(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 0;

    }
    public int updateClient(int primaryKey,String cloumn,int value){
        String Querry = querry.Clients.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,cloumn);
            stmt.setInt(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }

        return 0;
    }
    public int InsertClient(Client client){

        String a = querry.Clients.get(querry.INSERT);
        try {
            PreparedStatement stmt = con.prepareStatement(a);
            stmt.setString(1, client.getName()); // NAME
            stmt.setString(2, client.getLastName()); // LAST_NAME
            stmt.setDate(3, client.getBirthDate()); // BIRTH_DATE
            stmt.setString(4, client.getNationality()); // NATIONALITY
            stmt.setInt(5, client.getPhoneNumber()); // PHONE_NUMBER
            stmt.setInt(6, client.getCountryCode()); // COUNTRY_CODE
            stmt.setString(7, client.getEmail());
            int rowInserted = stmt.executeUpdate();
            System.out.println(rowInserted+"rows");
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        };
        return 0;
    }
    public int InsertHotel(Hotel hotel) {
        String sql = querry.Hotels.get(querry.INSERT);
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, hotel.getHotelName()); // HOTEL_NAME
            stmt.setString(2, hotel.getStreet()); // STREET
            stmt.setInt(3, hotel.getBuildingNumber()); // BUILDING_NUMBER
            stmt.setString(4, hotel.getPostCode()); // POST_CODE
            stmt.setString(5, hotel.getCity()); // CITY
            stmt.setString(6, hotel.getCountry()); // COUNTRY
            stmt.setInt(7, hotel.getPhoneNumber()); // PHONE_NUMBER
            stmt.setInt(8, hotel.getCountryCode()); // COUNTRY_CODE
            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " rows inserted.");
            return rowsInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int updateHotel(int primaryKey, String column, String value) {
        String sql = querry.Hotels.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, column);
            stmt.setString(2, value);
            stmt.setInt(3, primaryKey);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int updateHotel(int primaryKey, String column, int value) {
        String sql = querry.Hotels.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, column);
            stmt.setInt(2, value);
            stmt.setInt(3, primaryKey);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    public ArrayList<Hotel> getHotelTable() {
        String sql = querry.Hotels.get(querry.TABLE);
        ArrayList<Hotel> dataList = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = stmt.executeQuery();
            if (result.first()) {
                do {
                    Hotel tmp = new Hotel();
                    retrieveHotelData(tmp, result);
                    dataList.add(tmp);
                } while (result.next());
            } else {
                System.out.println("No data found in the hotel table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}







