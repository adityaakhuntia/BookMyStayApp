import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // ✅ VALIDATION ADDED
    public void reduceAvailability(String roomType) throws InvalidBookingException {

        int current = inventory.getOrDefault(roomType, 0);

        if (current <= 0) {
            throw new InvalidBookingException(
                    "Cannot reduce availability. No rooms left for " + roomType);
        }

        inventory.put(roomType, current - 1);
    }
}