package org.example.softdev_4t.controllers.HotelDrafts;

import org.example.softdev_4t.controllers.Hotel.HotelRoom;
import org.example.softdev_4t.controllers.Hotel.searchInterface;

import java.time.LocalDate;
// Mock object for HotelController.getSearchResults
// returns null
public class MockNull implements searchInterface {

    @Override
    public HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        return null;
    }
}