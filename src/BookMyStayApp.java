public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        // Room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Store in array (for polymorphism)
        Room[] rooms = {single, doubleRoom, suite};

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Search service
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform search (READ ONLY)
        searchService.searchAvailableRooms(rooms);
    }
}