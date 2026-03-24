public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Aditya", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));
        queue.addRequest(new Reservation("Aman", "Suite Room"));
        queue.addRequest(new Reservation("Neha", "Suite Room"));

        BookingService bookingService = new BookingService(inventory, queue);

        bookingService.processBookings();
    }
}