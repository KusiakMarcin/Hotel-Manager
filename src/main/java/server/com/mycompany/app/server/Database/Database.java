package server.com.mycompany.app.server.Database;

import client.com.mycompany.app.client.Client;

import java.sql.*;
import java.util.ArrayList;
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
            System.out.println(e+ "insertClient");
            return -1;
        }
        return 1;
    }
    public int updateClient(int primaryKey,String cloumn,int value){
        String Querry = querry.Guests.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,cloumn);
            stmt.setInt(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            System.out.println(e+ "updateClient");
            return -1;
        }

        return 1;
    }

    public int updateClient(int primaryKey,String column,String value){
        String Querry = querry.Guests.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,column);
            stmt.setString(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            System.out.println(e+ "updateClient");
            return -1;
        }

        return 1;

    }
    public int updateClient(int primaryKey,String column,Date value){
        String Querry = querry.Guests.get(querry.UPDATE);
        try {
            PreparedStatement stmt = con.prepareStatement(Querry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1,column);
            stmt.setDate(2,value);
            stmt.setInt(3,primaryKey);

            stmt.executeQuery();

        }catch (SQLException e){
            System.out.println(e + "updateClient");
            return -1;
        }
        return 1;
    }

    public ArrayList<Guest> getClientTable(){
        String Querry = querry.Guests.get(querry.TABLE);
        var tmp = new Guest();
        ArrayList<Guest> dataList = new ArrayList<Guest>();
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
            System.out.println(e + "getClientTable");
        }
        return dataList;
    }
    public Guest getClient(int primaryKey){

        String a = querry.Guests.get(querry.SELECT);
        var tmp = new Guest();
        try {
            PreparedStatement stmt = con.prepareStatement(a,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1,primaryKey);
            ResultSet result = stmt.executeQuery();

            result.first();
            retriveClientData(tmp,result);
//            tmp.setClientID(result.getInt("CLIENT_ID"));
//            tmp.setName(result.getString("NAME"));
//            tmp.setLastName(result.getString("LAST_NAME"));
//            tmp.setBirthDate(result.getDate("BIRTH_DATE"));
//            tmp.setNationality(result.getString("NATIONALITY"));
//            tmp.setPhoneNumber(result.getInt("PHONE_NUMBER"));
//            tmp.setCountryCode(result.getInt("COUNTRY_CODE"));
//            tmp.setEmail(result.getString("EMAIL_ADRESS"));

        }catch (SQLException e){
            System.out.println(e+" getClient");




        }
        return tmp;
    }
    public void retriveClientData(Guest guest ,ResultSet data){
        try {
            guest.setClientID(data.getInt("CLIENT_ID"));
            guest.setName(data.getString("NAME"));
            guest.setLastName(data.getString("LAST_NAME"));
            guest.setBirthDate(data.getDate("BIRTH_DATE"));
            guest.setNationality(data.getString("NATIONALITY"));
            guest.setPhoneNumber(data.getInt("PHONE_NUMBER"));
            guest.setCountryCode(data.getInt("COUNTRY_CODE"));
            guest.setEmail(data.getString("EMAIL_ADRESS"));
        }catch (SQLException e ){
            System.out.println(e);

        }
    }
}