import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue queue;
    private HashMap<String, Set<String>> allocatedRooms;
    private BookingHistory history;
    private CancellationService cancellationService; // NEW

    public BookingService(RoomInventory inventory,
                          BookingRequestQueue queue,
                          BookingHistory history,
                          CancellationService cancellationService) {

        this.inventory = inventory;
        this.queue = queue;
        this.history = history;
        this.cancellationService = cancellationService;
        allocatedRooms = new HashMap<>();
    }

    public void processBookings() {

        System.out.println("\n--- Processing Bookings ---");

        Reservation request;

        while ((request = queue.getNextRequest()) != null) {

            try {
                BookingValidator.validate(request, inventory);

                String roomType = request.getRoomType();

                String roomId = generateRoomId(roomType);

                allocatedRooms
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.reduceAvailability(roomType);

                history.addBooking(request);

                // ✅ register for cancellation
                cancellationService.registerReservation(roomId, roomType);

                System.out.println("Booking CONFIRMED for " +
                        request.getGuestName() +
                        " | Room ID: " + roomId);

            } catch (InvalidBookingException e) {

                System.out.println("Booking FAILED for " +
                        (request != null ? request.getGuestName() : "Unknown") +
                        " | Reason: " + e.getMessage());
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + System.nanoTime();
    }
}