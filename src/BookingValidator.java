import java.util.Arrays;
import java.util.List;

class BookingValidator {

    private static final List<String> validRoomTypes =
            Arrays.asList("Single Room", "Double Room", "Suite Room");

    // Validate booking input
    public static void validate(Reservation reservation, RoomInventory inventory)
            throws InvalidBookingException {

        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null");
        }

        if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Guest name is required");
        }

        String roomType = reservation.getRoomType();

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            throw new InvalidBookingException("No availability for " + roomType);
        }
    }
}