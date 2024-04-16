package org.example.softdev_4t.controllers.HotelDrafts;

import org.example.softdev_4t.controllers.Hotel.HotelRoom;
import org.example.softdev_4t.controllers.Hotel.searchInterface;

import java.time.LocalDate;
// Mock object for HotelController.getSearchResults
// returns an empty array
public class MockEmpty implements searchInterface {

    @Override
    public HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        return new HotelRoom[0];
    }
}