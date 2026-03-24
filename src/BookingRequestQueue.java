import java.util.LinkedList;
import java.util.Queue;

/**
 * BookingRequestQueue - Handles incoming booking requests
 * 
 * Maintains FIFO order for fairness.
 * No allocation or inventory update is done here.
 */
class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request to queue
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added for " + reservation.getGuestName() +
                " (" + reservation.getRoomType() + ")");
    }

    // Display all requests
    public void displayQueue() {
        System.out.println("\n--- Booking Request Queue ---");

        for (Reservation r : queue) {
            System.out.println(r.getGuestName() + " -> " + r.getRoomType());
        }
    }
}