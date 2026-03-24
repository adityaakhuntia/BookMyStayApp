import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println(Thread.currentThread().getName() +
                " added request for " +
                reservation.getGuestName());
    }

    public synchronized Reservation getNextRequest() {
        return queue.poll();
    }
}