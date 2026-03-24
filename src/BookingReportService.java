import java.util.List;

class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Display all bookings
    public void showAllBookings() {

        System.out.println("\n--- Booking History ---");

        List<Reservation> bookings = history.getAllBookings();

        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : bookings) {
            System.out.println("Guest: " + r.getGuestName() +
                    " | Room: " + r.getRoomType());
        }
    }

    // Summary report
    public void generateSummary() {

        int total = history.getAllBookings().size();

        System.out.println("\n--- Booking Summary ---");
        System.out.println("Total Bookings: " + total);
    }
}