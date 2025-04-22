import java.util.LinkedList;
import java.util.Scanner;

public class Event {
    private Scanner scanner;
    private LinkedList<EventData> events = new LinkedList<>();

    public Event(Scanner scanner) {
        this.scanner = scanner;
    }

    static class EventData {
        String eventId;
        String eventName;
        String eventDate;
        int capacity;
        int bookedSeats = 0;

        EventData(String eventId, String eventName, String eventDate, int capacity) {
            this.eventId = eventId;
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.capacity = capacity;
        }
    }

    public void addEvent() {
        System.out.print("Enter Event ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Event Date (dd/mm/yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        EventData newEvent = new EventData(id, name, date, capacity);
        events.add(newEvent);

        System.out.println("Event added successfully!");
    }

    public void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        System.out.println("\n--- List of Events ---");
        for (EventData event : events) {
            System.out.println("ID: " + event.eventId + ", Name: " + event.eventName + ", Date: " + event.eventDate +
                    ", Capacity: " + event.capacity + ", Booked: " + event.bookedSeats);
        }
    }

    public EventData findEventById(String eventId) {
        for (EventData event : events) {
            if (event.eventId.equals(eventId)) {
                return event;
            }
        }
        return null;
    }

    public void searchEvents() {
        System.out.print("Enter event name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (EventData event : events) {
            if (event.eventName.equalsIgnoreCase(searchName)) {
                System.out.println("Event Found: " + event.eventId + " - " + event.eventName);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Event not found.");
        }
    }

    public void sortEvents() {
        int n = events.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (events.get(j).eventName.compareTo(events.get(j + 1).eventName) > 0) {
                    EventData temp = events.get(j);
                    events.set(j, events.get(j + 1));
                    events.set(j + 1, temp);
                }
            }
        }

        System.out.println("Events sorted by name successfully!");
    }
}