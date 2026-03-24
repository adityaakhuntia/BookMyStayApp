public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Concurrent Booking Simulation =====");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        BookingHistory history = new BookingHistory();
        CancellationService cancellationService =
                new CancellationService(inventory, history);

        // MANY requests (simulate load)
        queue.addRequest(new Reservation("A", "Suite Room"));
        queue.addRequest(new Reservation("B", "Suite Room"));
        queue.addRequest(new Reservation("C", "Suite Room"));
        queue.addRequest(new Reservation("D", "Suite Room"));
        queue.addRequest(new Reservation("E", "Suite Room"));

        queue.addRequest(new Reservation("F", "Single Room"));
        queue.addRequest(new Reservation("G", "Single Room"));
        queue.addRequest(new Reservation("H", "Single Room"));

        BookingService bookingService =
                new BookingService(inventory, queue, history, cancellationService);

        // 🔥 MULTIPLE THREADS
        BookingWorker t1 = new BookingWorker(bookingService, "Thread-1");
        BookingWorker t2 = new BookingWorker(bookingService, "Thread-2");
        BookingWorker t3 = new BookingWorker(bookingService, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- FINAL REPORT ---");

        BookingReportService reportService =
                new BookingReportService(history);

        reportService.showAllBookings();
        reportService.generateSummary();
    }
}