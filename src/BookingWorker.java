class BookingWorker extends Thread {

    private BookingService bookingService;

    public BookingWorker(BookingService bookingService, String name) {
        super(name);
        this.bookingService = bookingService;
    }

    @Override
    public void run() {
        bookingService.processBookings();
    }
}