package server.com.mycompany.app;
import server.com.mycompany.app.server.*;
import server.com.mycompany.app.server.Database.*;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * bruh
 */
public class App {
    public static void main(String[] args) {
        Database db = new Database();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("\n--- Database Operations ---");
            System.out.println("1. Get Client by ID");
            System.out.println("2. Get Client Table");
            System.out.println("3. Insert Client");
            System.out.println("4. Update Client");
            System.out.println("5. Insert Hotel");
            System.out.println("6. Update Hotel");
            System.out.println("7. Get Hotel Table");
            System.out.println("8. Get Room Table");
            System.out.println("9. Insert Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: // Get Client by ID
                    System.out.print("Enter Client ID: ");
                    int clientId = scanner.nextInt();
                    Client client = db.getClient(clientId);
                    if (client != null) {
                        System.out.println("Client Details: " + client.toJSON().toString() + "\n");
                    } else {
                        System.out.println("Client not found.\n");
                    }
                    break;

                case 2: // Get Client Table
                    ArrayList<Client> clientList = db.getClientTable();
                    if (!clientList.isEmpty()) {
                        System.out.println("Client Table:");
                        for (Client c : clientList) {
                            System.out.println(c.toJSON().toString());
                        }
                    } else {
                        System.out.println("No clients found.\n"+ clientList.isEmpty());
                    }
                    break;

                case 3: // Insert Client
                    Client newClient = new Client();
                    System.out.print("Enter Client Name: ");
                    newClient.setName(scanner.next());
                    System.out.print("Enter Client Last Name: ");
                    newClient.setLastName(scanner.next());
                    System.out.print("Enter Birth Date (yyyy-mm-dd): ");
                    newClient.setBirthDate(Date.valueOf(scanner.next()));
                    System.out.print("Enter Nationality: ");
                    newClient.setNationality(scanner.next());
                    System.out.print("Enter Phone Number: ");
                    newClient.setPhoneNumber(scanner.nextInt());
                    System.out.print("Enter Country Code: ");
                    newClient.setCountryCode(scanner.nextInt());
                    System.out.print("Enter Email Address: ");
                    newClient.setEmail(scanner.next());
                    int insertClientResult = db.InsertClient(newClient);
                    if (insertClientResult == 0) {
                        System.out.println("Client successfully inserted.\n");
                    } else {
                        System.out.println("Failed to insert client.\n");
                    }
                    break;

                case 4: // Update Client
                    System.out.print("Enter Client ID to Update: ");
                    int updateClientId = scanner.nextInt();
                    System.out.print("Enter Column to Update: ");
                    String column = scanner.next();
                    System.out.print("Enter New Value: ");
                    if (column.equalsIgnoreCase("BIRTH_DATE")) {
                        Date dateValue = Date.valueOf(scanner.next());
                        int result = db.updateClient(updateClientId, column, dateValue);
                        System.out.println(result == 0 ? "Client updated successfully.\n" : "Failed to update client.\n");
                    } else if (scanner.hasNextInt()) {
                        int intValue = scanner.nextInt();
                        int result = db.updateClient(updateClientId, column, intValue);
                        System.out.println(result == 0 ? "Client updated successfully.\n" : "Failed to update client.\n");
                    } else {
                        String strValue = scanner.next();
                        int result = db.updateClient(updateClientId, column, strValue);
                        System.out.println(result == 0 ? "Client updated successfully.\n" : "Failed to update client.\n");
                    }
                    break;

                case 5: // Insert Hotel
                    Hotel newHotel = new Hotel();
                    System.out.print("Enter Hotel Name: ");
                    newHotel.setHotelName(scanner.next());
                    System.out.print("Enter Street: ");
                    newHotel.setStreet(scanner.next());
                    System.out.print("Enter Building Number: ");
                    newHotel.setBuildingNumber(scanner.nextInt());
                    System.out.print("Enter Post Code: ");
                    newHotel.setPostCode(scanner.next());
                    System.out.print("Enter City: ");
                    newHotel.setCity(scanner.next());
                    System.out.print("Enter Country: ");
                    newHotel.setCountry(scanner.next());
                    System.out.print("Enter Phone Number: ");
                    newHotel.setPhoneNumber(scanner.nextInt());
                    System.out.print("Enter Country Code: ");
                    newHotel.setCountryCode(scanner.nextInt());
                    int insertHotelResult = db.InsertHotel(newHotel);
                    System.out.println(insertHotelResult == 0 ? "Hotel successfully inserted.\n" : "Failed to insert hotel.\n");
                    break;

                case 6: // Update Hotel
                    System.out.print("Enter Hotel ID to Update: ");
                    int updateHotelId = scanner.nextInt();
                    System.out.print("Enter Column to Update: ");
                    String hotelColumn = scanner.next();
                    System.out.print("Enter New Value: ");
                    if (scanner.hasNextInt()) {
                        int hotelIntValue = scanner.nextInt();
                        int result = db.updateHotel(updateHotelId, hotelColumn, hotelIntValue);
                        System.out.println(result == 0 ? "Hotel updated successfully.\n" : "Failed to update hotel.\n");
                    } else {
                        String hotelStrValue = scanner.next();
                        int result = db.updateHotel(updateHotelId, hotelColumn, hotelStrValue);
                        System.out.println(result == 0 ? "Hotel updated successfully.\n" : "Failed to update hotel.\n");
                    }
                    break;

                case 7: // Get Hotel Table
                    ArrayList<Hotel> hotelList = db.getHotelTable();
                    if (!hotelList.isEmpty()) {
                        System.out.println("Hotel Table:");
                        for (Hotel h : hotelList) {
                            System.out.println(h.toJSON().toString());
                        }
                    } else {
                        System.out.println("No hotels found.\n");
                    }
                    break;

                case 8: // Get Room Table
                    ArrayList<Room> roomList = db.getRoomTable();
                    if (!roomList.isEmpty()) {
                        System.out.println("Room Table:");
                        for (Room r : roomList) {
                            System.out.println(r.toJSON().toString());
                        }
                    } else {
                        System.out.println("No rooms found.\n");
                    }
                    break;

//                case 9: // Insert Employee
//                    Employee newEmployee = new Employee();
//                    System.out.print("Enter Employee Name: ");
//                    newEmployee.setEmployeeName(scanner.next());
//                    System.out.print("Enter Employee Last Name: ");
//                    newEmployee.setEmployeeLastName(scanner.next());
//                    System.out.print("Enter Nationality: ");
//                    newEmployee.setEmployeeNationality(scanner.next());
//                    System.out.print("Enter Birth Date (yyyy-mm-dd): ");
//                    newEmployee.setEmployeeBirth(Date.valueOf(scanner.next()));
//                    int insertEmployeeResult = db.insertEmployee(newEmployee);
//                    System.out.println(insertEmployeeResult == 0 ? "Employee successfully inserted.\n" : "Failed to insert employee.\n");
//                    break;

                case 0: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }


    }
}
