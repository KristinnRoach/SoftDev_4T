package org.example.softdev_4t;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import throunhu.is.hi.Tour;
import throunhu.is.hi.TourDatabase;

import static javafx.scene.control.Alert.AlertType.WARNING;
import static org.example.softdev_4t.utilz.*;

public class MainCtrl {

    private TourDatabase tourDb;


    @FXML
    private Label appTitle;
    @FXML
    public Accordion resAccTour;
    @FXML
    public Accordion resAccFlight;
    @FXML
    public Accordion resAccHotel;

    @FXML
    public TextField toLocation;
    @FXML
    public TextField fromLocation;
    @FXML
    public DatePicker depDatePicker;
    @FXML
    public DatePicker retDatePicker;
    @FXML
    public TextField nrPassengers;
    @FXML
    public Button searchButton;

    @FXML
    public GridPane booking;
    @FXML
    public VBox cartVb;
    @FXML
    public Button clearCartBtn;
    @FXML
    public Button confirmBookingBtn;




    @FXML
    private void initialize() {
        this.tourDb = new TourDatabase();
        initBtns();
        playTitle(appTitle);
    }

    public void initBtns() {
        clearCartBtn.setOnAction(event -> {
            Optional<ButtonType> confirmed = confirm("Clear Cart?");
            if (confirmed.isPresent() && confirmed.get() == ButtonType.OK) {
                handleClearCart();
            }
        });
        confirmBookingBtn.setOnAction(event -> {
            Optional<ButtonType> confirmed = confirm("Confirm Booking?");
            if (confirmed.isPresent() && confirmed.get() == ButtonType.OK) {
                handleBooking();
            }
        });
    }

    protected boolean validateData(String depLoc, String destLoc, LocalDate depDate, LocalDate retDate, int passengers) {
        Alert alert = new Alert(WARNING);
        alert.setTitle("Invalid Data");
        if(invalidDateMessage(depDate, retDate) != null) {
            alert.setContentText(invalidDateMessage(depDate, retDate));
            alert.showAndWait();
            return false;
        }
        if(invalidPplMessage(passengers) != null) {
            alert.setContentText(invalidPplMessage(passengers));
            alert.showAndWait();
            return false;

        }
        if (invalidLocationMessage(depLoc, destLoc) != null) {
            alert.setContentText(invalidLocationMessage(depLoc, destLoc));
            alert.showAndWait();
            return false;
        }
        return true;
    }


    @FXML
    protected void onSearch() throws SQLException {

        LocalDate depDate = depDatePicker.getValue();
        LocalDate retDate = depDatePicker.getValue();

        if (! validateData(fromLocation.getText(),
                toLocation.getText(),
                depDate,
                retDate,
                Integer.parseInt(nrPassengers.getText())
                )) { return; }

        String depLoc = fromLocation.getText();
        String destLoc = toLocation.getText();
        int passengers = Integer.parseInt(nrPassengers.getText());

        LocalDate[] timeframe = getTimeframe(depDate, retDate);

        List<Tour> flightResults;
        List<Tour> hotelResults;
        List<Tour> tourResults = tourDb.searchTourbyDateandLoc(destLoc, localDateToString(depDate));

        updateSearchResults(tourResults); // flightResults, hotelResults


        // searchFlights(fromLocation, toLocation, depDatePicker, nrPassengers)
        // searchHotels(toLocation, depDatePicker, nrPassengers)
        // searchTrips(fromLocation, toLocation, depDatePicker, nrPassengers)
    }


    public void updateSearchResults(List<Tour> searchResults) {
        for (Tour aTour : searchResults) {
            String[] details = aTour.getInfo();
            String resultHeader = details[1] + ", " + details[2] + ", " + details[3];
            TitledPane tp = new TitledPane(resultHeader, null);

            VBox contentVBox = new VBox();
            for (int i = 2; i < details.length; i++) {
                contentVBox.getChildren().add(new Label(details[i]));
                contentVBox.getStyleClass().add("bg-bright");
            }
            Button addToCartButton = new Button("Add to Cart!");
            addToCartButton.setOnAction(event -> {
                Optional<ButtonType> confirmed = confirm("Add to Cart?");
                if (confirmed.isPresent() && confirmed.get() == ButtonType.OK) {
                    addToCart(aTour, resultHeader);
                }
            });
            contentVBox.getChildren().add(addToCartButton);
            tp.setContent(contentVBox);
            resAccTour.getPanes().add(tp);
        }
    }

    private void addToCart(Tour tour, String tourHeader){
        String[] details = tour.getInfo();
        cartVb.getChildren().add(new Label(tourHeader));
    }

    public Optional<ButtonType> confirm(String confirmText) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, confirmText);
        return confirm.showAndWait();
    }

    public void handleClearCart() {
        cartVb.getChildren().removeAll();
    }


    public void handleBooking() {

    }



}