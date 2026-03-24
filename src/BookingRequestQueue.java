import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added for " +
                reservation.getGuestName() +
                " (" + reservation.getRoomType() + ")");
    }

    // ✅ NEW (UC6)
    public Reservation getNextRequest() {
        return queue.poll();
    }
}