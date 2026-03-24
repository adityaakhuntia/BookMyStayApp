import java.util.HashMap;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public synchronized int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public synchronized void reduceAvailability(String roomType)
            throws InvalidBookingException {

        int current = inventory.getOrDefault(roomType, 0);

        if (current <= 0) {
            throw new InvalidBookingException(
                    "No rooms left for " + roomType);
        }

        inventory.put(roomType, current - 1);
    }

    public synchronized void increaseAvailability(String roomType) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + 1);
    }
}