public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to BookMyStayApp v1.0 =====");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add requests
        Reservation r1 = new Reservation("Aditya", "Single Room");
        Reservation r2 = new Reservation("Rahul", "Suite Room");

        queue.addRequest(r1);
        queue.addRequest(r2);

        BookingService bookingService = new BookingService(inventory, queue);

        // NEW: Add-on manager
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Process ONE booking and attach services
        String resId1 = bookingService.processSingleBooking(r1);

        if (resId1 != null) {

            serviceManager.addService(resId1, new AddOnService("Breakfast", 500));
            serviceManager.addService(resId1, new AddOnService("Airport Pickup", 1200));

            serviceManager.displayServices(resId1);

            double cost = serviceManager.calculateTotalCost(resId1);

            System.out.println("Total Add-On Cost: ₹" + cost);
        }
    }
}