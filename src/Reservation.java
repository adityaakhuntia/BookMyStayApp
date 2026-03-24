/**
 * Reservation - Represents a booking request
 * 
 * This class stores guest intent to book a room.
 * No allocation happens here.
 * 
 * @author Aditya Khuntia
 * @version 1.0
 */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}