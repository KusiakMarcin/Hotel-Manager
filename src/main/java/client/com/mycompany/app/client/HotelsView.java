package client.com.mycompany.app.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HotelsView {
/*
    @FXML
    private TextField txtHotelName, txtStreet, txtBuildingNumber, txtPostCode, txtCity, txtCountry, txtPhoneNumber, txtCountryCode;
    @FXML
    private TableView<Hotel> hotelsTable;
    @FXML
    private TableColumn<Hotel, String> columnHotelName, columnStreet, columnBuildingNumber, columnPostCode, columnCity, columnCountry, columnPhoneNumber, columnCountryCode;

    private final ObservableList<Hotel> hotels = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnHotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        columnStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        columnBuildingNumber.setCellValueFactory(new PropertyValueFactory<>("buildingNumber"));
        columnPostCode.setCellValueFactory(new PropertyValueFactory<>("postCode"));
        columnCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        columnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columnCountryCode.setCellValueFactory(new PropertyValueFactory<>("countryCode"));

        hotelsTable.setItems(hotels);
        hotelsTable.setOnMouseClicked(this::handleRowClick);
    }

    private void handleRowClick(MouseEvent event) {
        Hotel selectedHotel = hotelsTable.getSelectionModel().getSelectedItem();
        if (selectedHotel != null) {
            txtHotelName.setText(selectedHotel.getHotelName());
            txtStreet.setText(selectedHotel.getStreet());
            txtBuildingNumber.setText(selectedHotel.getBuildingNumber());
            txtPostCode.setText(selectedHotel.getPostCode());
            txtCity.setText(selectedHotel.getCity());
            txtCountry.setText(selectedHotel.getCountry());
            txtPhoneNumber.setText(selectedHotel.getPhoneNumber());
            txtCountryCode.setText(selectedHotel.getCountryCode());
        }
    }

*/
}
