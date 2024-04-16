package org.example.softdev_4t.controllers.Hotel;

import java.time.LocalDate;

public interface searchInterface {
    HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice);
}
