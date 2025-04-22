import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Booking {
    private Scanner scanner;
    private LinkedList<BookingData> bookings = new LinkedList<>();
    private Queue<String> waitlist = new LinkedList<>();

    private User userManager;
    private Event eventManager;

    public Booking(User userManager, Event eventManager, Scanner scanner) {
        this.userManager = userManager;
        this.eventManager = eventManager;
        this.scanner = scanner;
    }

    private static class BookingData {
        String userId;
        String eventId;

        BookingData(String userId, String eventId) {
            this.userId = userId;
            this.eventId = eventId;
        }
    }

    public void bookTicket() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();

        User.UserData user = userManager.findUserById(userId);
        Event.EventData event = eventManager.findEventById(eventId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        if (event.bookedSeats < event.capacity) {
            event.bookedSeats++;
            bookings.add(new BookingData(userId, eventId));
            System.out.println("Ticket booked successfully!");
        } else {
            waitlist.add(userId);
            System.out.println("Event full. User added to waitlist.");
        }
    }

    public void cancelTicket() {
        System.out.print("Enter User ID to cancel booking: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();

        boolean found = false;
        for (BookingData booking : bookings) {
            if (booking.userId.equals(userId) && booking.eventId.equals(eventId)) {
                bookings.remove(booking);
                Event.EventData event = eventManager.findEventById(eventId);
                if (event != null) {
                    event.bookedSeats--;
                }

                if (!waitlist.isEmpty()) {
                    String nextUserId = waitlist.poll();
                    bookings.add(new BookingData(nextUserId, eventId));
                    if (event != null) {
                        event.bookedSeats++;
                    }
                    System.out.println("Next user from waitlist booked!");
                }

                System.out.println("Booking cancelled successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found.");
        }
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        System.out.println("\n--- List of Bookings ---");
        for (BookingData booking : bookings) {
            System.out.println("User ID: " + booking.userId + ", Event ID: " + booking.eventId);
        }
    }
}