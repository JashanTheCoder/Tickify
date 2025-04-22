import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User userManager = new User();
        Event eventManager = new Event(scanner);
        Booking bookingManager = new Booking(userManager , eventManager, scanner);

        while (true) {
            System.out.println("\n--- Event Registration & Ticket Booking ---");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Add Event");
            System.out.println("4. View Events");
            System.out.println("5. Book Ticket");
            System.out.println("6. Cancel Ticket");
            System.out.println("7. View Bookings");
            System.out.println("8. Search Events");
            System.out.println("9. Sort Events");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("______________________________");
                    userManager.addUser(scanner);
                    break;
                case "2":
                    userManager.viewUsers();
                    break;
                case "3":
                    eventManager.addEvent();
                    break;
                case "4":
                    eventManager.viewEvents();
                    break;
                case "5":
                    bookingManager.bookTicket();
                    break;
                case "6":
                    bookingManager.cancelTicket();
                    break;
                case "7":
                    bookingManager.viewBookings();
                    break;
                case "8":
                    eventManager.searchEvents();
                    break;
                case "9":
                    eventManager.sortEvents();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}