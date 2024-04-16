package org.example.softdev_4t.controllers.Hotel;

import java.time.LocalDate;
import java.util.Arrays;

public class HotelRoom {

    /* GETTERS */

    public String getLocation() {
        return location;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public String getHotelName() {
        return HotelName;
    }

    public int getNrOfBeds() {
        return nrOfBeds;
    }

    public LocalDate[] getAvailableDates() {
        return availableDates;
    }

    /* FIELDS */

    private final String HotelName;
    private final String location;
    private final int nrOfBeds;
    private final Integer pricePerNight;  // Integer (ekki integer) leyfir null values
    private final LocalDate[] availableDates;

    /* Constructor */

    public HotelRoom(String HotelName, String location, int nrOfBeds, LocalDate[] availableDates, Integer pricePerNight) {
        this.HotelName = HotelName;
        this.location = location;
        this.nrOfBeds = nrOfBeds;
        this.pricePerNight = pricePerNight;
        this.availableDates = availableDates;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "HotelName='" + HotelName + '\'' +
                ", location='" + location + '\'' +
                ", nrOfBeds=" + nrOfBeds +
                ", pricePerNight=" + pricePerNight +
                ", availableDates=" + Arrays.toString(availableDates) +
                '}';
    }
}
