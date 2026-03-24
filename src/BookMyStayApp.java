public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        // Inventory (still read-only here)
        RoomInventory inventory = new RoomInventory();

        // Queue for booking requests
        BookingRequestQueue requestQueue = new BookingRequestQueue();

        // Sample booking requests
        Reservation r1 = new Reservation("Aditya", "Single Room");
        Reservation r2 = new Reservation("Rahul", "Double Room");
        Reservation r3 = new Reservation("Priya", "Suite Room");

        // Add to queue (FIFO)
        requestQueue.addRequest(r1);
        requestQueue.addRequest(r2);
        requestQueue.addRequest(r3);

        // Display queue
        requestQueue.displayQueue();
    }
}