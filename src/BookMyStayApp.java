public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== System Recovery Demo =====");

        PersistenceService persistence = new PersistenceService();

        RoomInventory inventory;
        BookingHistory history;

        // 🔥 LOAD STATE
        Object[] data = persistence.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            history = (BookingHistory) data[1];
        } else {
            inventory = new RoomInventory();
            history = new BookingHistory();
        }

        BookingRequestQueue queue = new BookingRequestQueue();
        CancellationService cancellationService =
                new CancellationService(inventory, history);

        // Add new bookings
        queue.addRequest(new Reservation("Aditya", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Suite Room"));

        BookingService bookingService =
                new BookingService(inventory, queue, history, cancellationService);

        bookingService.processBookings();

        // Show history
        BookingReportService reportService =
                new BookingReportService(history);

        reportService.showAllBookings();
        reportService.generateSummary();

        // 🔥 SAVE STATE BEFORE EXIT
        persistence.save(inventory, history);
    }
}