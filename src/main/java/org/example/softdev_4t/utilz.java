package org.example.softdev_4t;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class utilz {

    public static void playTitle(Label appTitle) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(4), appTitle);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();
    }

    public static LocalDate[] getTimeframe(LocalDate start, LocalDate end) {
        long numOfDays = start.until(end.plusDays(1)).getDays();

        List<LocalDate> dateList = new ArrayList<>();

        for (int i = 0; i < numOfDays; i++) {
            LocalDate currentDate = start.plusDays(i);
            dateList.add(currentDate);
        }
        return dateList.toArray(new LocalDate[0]);
    }
    public static String localDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public static LocalDate stringToLocalDate(String yyyy_MM_dd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(yyyy_MM_dd, formatter);
    }

    public static String invalidDateMessage(LocalDate arrival, LocalDate departure) {
        if (arrival == null || departure == null) {
            return "Arrival date or departure date missing!";
        }
        if (arrival.isBefore(LocalDate.now()) || arrival.isAfter(departure) || arrival.isEqual(departure)) {
            return "Arrival date should be before departure date and the current date";
        }
        return null;
    }

    public static String invalidPplMessage(int nrPpl) {
        if (! (nrPpl > 0 && nrPpl < 50)) {
            return "Invalid number of passengers";
        }
        return null;
    }

    public static String invalidLocationMessage(String depLoc, String destLoc) {

        return null;
    }

}
