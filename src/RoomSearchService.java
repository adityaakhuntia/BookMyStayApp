/**
 * RoomSearchService - Handles searching available rooms
 * 
 * This class performs read-only operations on inventory
 * and displays only available rooms.
 * 
 * @author Aditya Khuntia
 * @version 1.0
 */
class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Search and display available rooms
    public void searchAvailableRooms(Room[] rooms) {

        System.out.println("\n--- Available Rooms ---");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getType());
            // Show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}