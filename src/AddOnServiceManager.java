import java.util.*;

class AddOnServiceManager {

    // reservationId -> list of services
    private HashMap<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap
            .computeIfAbsent(reservationId, k -> new ArrayList<>())
            .add(service);

        System.out.println(service.getName() + 
            " added to Reservation " + reservationId);
    }

    // Calculate total add-on cost
    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services != null) {
            for (AddOnService s : services) {
                total += s.getPrice();
            }
        }

        return total;
    }

    // Display services
    public void displayServices(String reservationId) {

        List<AddOnService> services = serviceMap.get(reservationId);

        System.out.println("\nServices for Reservation " + reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService s : services) {
            System.out.println("- " + s.getName() + " (₹" + s.getPrice() + ")");
        }
    }
}