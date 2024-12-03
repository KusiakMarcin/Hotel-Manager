package server.com.mycompany.app.server.Database;

import client.com.mycompany.app.client.Client;

import java.sql.*;
import java.util.Properties;
public class Database {
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private Connection con;
    private Properties props = new Properties();
    private Querries querry = new Querries();
    public Database(String username,String password) {

        props.put("user", "SYS");
        props.put("password", "admin");
        props.put("internal_logon", "SYSDBA");
        try {

            // Establish connection
            con = DriverManager.getConnection(url,props);
            System.out.println("Connected Database");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
    public int InsertClient(Guest guest){

        String a = querry.Guests.get(querry.INSERT);
        try {
            PreparedStatement stmt = con.prepareStatement(a);
            stmt.setString(1, guest.getName()); // NAME
            stmt.setString(2, guest.getLastName()); // LAST_NAME
            stmt.setDate(3, guest.getBirthDate()); // BIRTH_DATE
            stmt.setString(4, guest.getNationality()); // NATIONALITY
            stmt.setInt(5, guest.getPhoneNumber()); // PHONE_NUMBER
            stmt.setInt(6, guest.getCountryCode()); // COUNTRY_CODE
            stmt.setString(7, guest.getEmail());
            int rowInserted = stmt.executeUpdate();
            System.out.println(rowInserted+"rows");
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
        return 1;
    }

    public Guest getClient(){

        String a = querry.Guests.get(querry.SELECT);
        var tmp = new Guest();
        try {
            PreparedStatement stmt = con.prepareStatement(a,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet result = stmt.executeQuery(a);
            result.first();
            tmp.setClientID(result.getInt("CLIENT_ID"));
            tmp.setName(result.getString("NAME"));
            tmp.setLastName(result.getString("LAST_NAME"));
            tmp.setBirthDate(result.getDate("BIRTH_DATE"));
            tmp.setNationality(result.getString("NATIONALITY"));
            tmp.setPhoneNumber(result.getInt("PHONE_NUMBER"));
            tmp.setCountryCode(result.getInt("COUNTRY_CODE"));
            tmp.setEmail(result.getString("EMAIL_ADRESS"));

        }catch (SQLException e){
            System.out.println(e);


        }
        return tmp;
    }
}