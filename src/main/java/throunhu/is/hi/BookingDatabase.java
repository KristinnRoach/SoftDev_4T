/*

package throunhu.is.hi;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import throunhu.is.hi.TourController;

public class BookingDatabase {

    private Database db;


    public void addBookingToDatabase(Booking booking) throws SQLException {
        String insertSQL = "INSERT INTO Bookings (customerID, tourID, bookingDate, bookingTime, numSpots, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, booking.getCustomer().getKennitala());
            pstmt.setInt(2, booking.getTourID());
            pstmt.setDate(3, booking.getBookingDate());
            pstmt.setTime(4, booking.getBookingTime());
            pstmt.setInt(5, booking.getNumSpots());
            pstmt.setInt(6, booking.getPrice());
            pstmt.executeUpdate();
            System.out.println("Booking successful");
        } catch (SQLException e) {
            System.out.println("Failed to add booking: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeBooking(int bookingID) throws SQLException {
        String removeSQL = "DELETE FROM Bookings WHERE bookingID = ?";
        // try (Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(removeSQL)) {
            pstmt.setInt(1, bookingID);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 1) {
                System.out.println("Booking successfully cancelled.");
            } else if (affectedRows == 0) {
                System.out.println("No booking found with ID: " + bookingID);
            } else {
                System.out.println("Only one booking can be cancelled at a time " + affectedRows);
            }
        } catch (SQLException e) {
            System.out.println("Error removing booking: " + e.getMessage());
        }
    }


    public void update (Booking booking){

    }

}
*/
