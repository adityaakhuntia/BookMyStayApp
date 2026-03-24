import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue queue;
    private HashMap<String, Set<String>> allocatedRooms;

    public BookingService(RoomInventory inventory, BookingRequestQueue queue) {
        this.inventory = inventory;
        this.queue = queue;
        allocatedRooms = new HashMap<>();
    }

    public void processBookings() {

        System.out.println("\n--- Processing Bookings ---");

        Reservation request;

        while ((request = queue.getNextRequest()) != null) {

            String roomType = request.getRoomType();
            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                String roomId = generateRoomId(roomType);

                allocatedRooms
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.reduceAvailability(roomType);

                String reservationId = roomId; // using roomId as reservationId
                System.out.println("Booking CONFIRMED for " +
        request.getGuestName() +
        " | Reservation ID: " + reservationId);

                        

            } else {
                System.out.println("Booking FAILED for " +
                        request.getGuestName() +
                        " (No rooms available)");
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + System.nanoTime();
    }

    public String processSingleBooking(Reservation request) {

    String roomType = request.getRoomType();
    int available = inventory.getAvailability(roomType);

    if (available > 0) {

        String roomId = generateRoomId(roomType);

        allocatedRooms
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.reduceAvailability(roomType);

        return roomId; // reservation ID
    }

    return null;
}
}