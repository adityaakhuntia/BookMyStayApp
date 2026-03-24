import java.io.*;

class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // Save state
    public void save(RoomInventory inventory, BookingHistory history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(history);

            System.out.println("\nSystem state saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving system state: " + e.getMessage());
        }
    }

    // Load state
    public Object[] load() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) ois.readObject();
            BookingHistory history = (BookingHistory) ois.readObject();

            System.out.println("System state restored successfully.");

            return new Object[]{inventory, history};

        } catch (Exception e) {

            System.out.println("No previous state found. Starting fresh.");

            return null;
        }
    }
}