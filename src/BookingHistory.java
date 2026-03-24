import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addBooking(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllBookings() {
        return history;
    }
}