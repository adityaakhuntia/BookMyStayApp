import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class CancellationService {

    private RoomInventory inventory;
    private BookingHistory history;

    // reservationId -> roomType
    private Map<String, String> reservationMap;

    // rollback stack (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
        reservationMap = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    // Register confirmed booking (called from BookingService)
    public void registerReservation(String reservationId, String roomType) {
        reservationMap.put(reservationId, roomType);
    }

    // Cancel booking
    public void cancel(String reservationId) {

        System.out.println("\n--- Cancellation Request ---");

        if (!reservationMap.containsKey(reservationId)) {
            System.out.println("Cancellation FAILED: Invalid or already cancelled reservation");
            return;
        }

        String roomType = reservationMap.get(reservationId);

        // Push to rollback stack
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.increaseAvailability(roomType);

        // Remove from map (prevent double cancel)
        reservationMap.remove(reservationId);

        System.out.println("Cancellation SUCCESS for Reservation ID: " + reservationId);
    }
}