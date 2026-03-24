public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingHistory history = new BookingHistory();

        // ✅ VALID BOOKINGS
        queue.addRequest(new Reservation("Aditya", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));

        // ❌ INVALID CASES (UC9 testing)
        queue.addRequest(new Reservation("", "Suite Room")); // empty name
        queue.addRequest(new Reservation("Priya", "Luxury Room")); // invalid type

        // Overbooking test
        queue.addRequest(new Reservation("Aman", "Suite Room"));
        queue.addRequest(new Reservation("Neha", "Suite Room"));
        queue.addRequest(new Reservation("Extra", "Suite Room")); // should fail

        BookingService bookingService =
                new BookingService(inventory, queue, history);

        bookingService.processBookings();

        BookingReportService reportService =
                new BookingReportService(history);

        reportService.showAllBookings();
        reportService.generateSummary();
    }
}