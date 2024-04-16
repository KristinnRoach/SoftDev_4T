package org.example.softdev_4t.controllers.Hotel;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class HotelCtrl {
    private final LocalDate currentDate = LocalDate.now();
    private final searchInterface hotelSearchObj;

    public HotelCtrl(searchInterface hotelSearchObj) {
        this.hotelSearchObj = hotelSearchObj;
    }

    private boolean validateSearchData(LocalDate arrival, LocalDate departure, String location) {
        if (arrival == null || departure == null || location == null) {
            System.out.println("Valid arrival date, departure date or location missing.");
            throw new IllegalArgumentException("Valid arrival date, departure date or location missing.");
        }
        if (arrival.isBefore(currentDate) || arrival.isAfter(departure) || arrival.isEqual(departure)) {
            System.out.println("Arrival date should be before departure date and the current date");
            throw new IllegalArgumentException("Arrival date should be before departure date and the current date");
        }
        return true;
    }

    // Returns an array of hotel rooms that match the search criteria, an empty array if no results are found
    public HotelRoom[] getSearchResults(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        HotelRoom[] searchResults = null;
        if (validateSearchData(arrival, departure, location)) {
            searchResults = hotelSearchObj.searchHotels(location, arrival, departure, maxPrice);
        }
        if (searchResults == null || searchResults.length == 0 || Arrays.stream(searchResults).allMatch(Objects::isNull)) {
            System.out.println("No available hotels found: " + Arrays.toString(searchResults));
            return new HotelRoom[0];
        }
        // Sorts search results, first by price, then hotel name alphabetically
        Arrays.sort(searchResults, Comparator.nullsLast(Comparator.comparing(HotelRoom::getPricePerNight))
                .thenComparing(HotelRoom::getHotelName));

        System.out.println("whh " + Arrays.toString(searchResults)); // henda
        return searchResults;
    }
}