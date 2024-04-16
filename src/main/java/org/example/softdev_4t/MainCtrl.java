package org.example.softdev_4t;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;


import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import throunhu.is.hi.Tour;
import throunhu.is.hi.TourDatabase;

public class MainCtrl {

    private TourDatabase tourDb;


    @FXML
    public ListView<List<String>> hotelListView;
    @FXML
    public ListView<List<String>> flightListView;
    @FXML
    private ListView<List<String>> tourListView;
    @FXML
    public TextField fromLocation;
    @FXML
    public DatePicker depDatePicker;
    @FXML
    public TextField dateTextField;
    @FXML
    public TextField nrPassengers;
    @FXML
    public Button searchButton;
    @FXML
    public TextField toLocation;
    @FXML
    private AnchorPane root;
    @FXML
    private Tab flightTab;
    @FXML
    private Label appTitle;


    @FXML
    private void initialize() {
        this.tourDb = new TourDatabase();

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(4), appTitle);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();
    }

    @FXML
    protected void onSearch() throws SQLException {
        //String from = fromLocation.getText();
        String destination = toLocation.getText();
        String selectedDate = dateTextField.getText();
        // int passengers = Integer.parseInt(nrPassengers.getText());
        System.out.println(selectedDate);
        List<Tour> searchResults = tourDb.searchTourbyDateandLoc(destination, selectedDate);
        updateSearchResults(searchResults);

        // searchFlights(fromLocation, toLocation, depDatePicker, nrPassengers)
        // searchHotels(toLocation, depDatePicker, nrPassengers)
        // searchTrips(fromLocation, toLocation, depDatePicker, nrPassengers)
        //getSearchResults();
    }

    public void updateSearchResults(List<Tour> searchResults) {
        ObservableList<List<String>> tourDetails = FXCollections.observableArrayList();
        for (Tour tour : searchResults) {
            List<String> tourInfo = tour.getInfo();
            tourDetails.add(tourInfo);
        }
        tourListView.setItems(tourDetails);
    }

}