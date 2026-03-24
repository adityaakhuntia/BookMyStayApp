import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BookingService {

    private RoomInventory inventory;
    private BookingRequestQueue queue;
    private HashMap<String, Set<String>> allocatedRooms;
    private BookingHistory history;
    private CancellationService cancellationService;

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

        Reservation request;

        while (true) {

            synchronized (queue) {
                request = queue.getNextRequest();
            }

            if (request == null) break;

            try {
                BookingValidator.validate(request, inventory);

                // 🔒 CRITICAL SECTION
                synchronized (this) {

                    String roomType = request.getRoomType();

                    String roomId = generateRoomId(roomType);

                    allocatedRooms
                            .computeIfAbsent(roomType, k -> new HashSet<>())
                            .add(roomId);

                    inventory.reduceAvailability(roomType);

                    history.addBooking(request);

                    cancellationService.registerReservation(roomId, roomType);

                    System.out.println(Thread.currentThread().getName() +
                            " CONFIRMED for " +
                            request.getGuestName() +
                            " | Room ID: " + roomId);
                }

            } catch (InvalidBookingException e) {

                System.out.println(Thread.currentThread().getName() +
                        " FAILED for " +
                        request.getGuestName() +
                        " | " + e.getMessage());
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + System.nanoTime();
    }
}