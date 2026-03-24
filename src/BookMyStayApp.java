public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingHistory history = new BookingHistory();

        // ✅ NEW
        CancellationService cancellationService =
                new CancellationService(inventory, history);

        // Requests
        queue.addRequest(new Reservation("Aditya", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Suite Room"));

        BookingService bookingService =
                new BookingService(inventory, queue, history, cancellationService);

        bookingService.processBookings();

        // ⚡ TEST CANCELLATION
        System.out.println("\n--- Testing Cancellation ---");

        // ⚠️ paste one printed Room ID here after first run
        // example:
        // cancellationService.cancel("SI-123456");

        // Reporting
        BookingReportService reportService =
                new BookingReportService(history);

        reportService.showAllBookings();
        reportService.generateSummary();
    }
}