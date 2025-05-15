import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private LinkedList<UserData> users = new LinkedList<>();

    class UserData {
        String userId;
        String name;
        String email;

        UserData(String userId, String name, String email) {
            this.userId = userId;
            this.name = name;
            this.email = email;
        }
    }

    public void addUser(Scanner scanner) {
    String id, name, email;
    Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Validate User ID
    while (true) {
        System.out.print("Enter User ID: ");
        id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("User ID cannot be empty. Please try again.");
        } else if (findUserById(id) != null) {
            System.out.println("User ID already exists. Please enter a unique ID.");
        } else {
            break;
        }
    }

    // Validate Name
    while (true) {
    System.out.print("Enter Name: ");
    name = scanner.nextLine().trim();
    
    if (name.isEmpty()) {
        System.out.println("Name cannot be empty. Please try again.");
    } else if (!name.matches("^[A-Za-z ]+$")) {
        System.out.println("Name must contain only letters and spaces. Please try again.");
    } else {
        break;
    }
}


    // Validate Email
    while (true) {
        System.out.print("Enter Email: ");
        email = scanner.nextLine().trim();
        if (!emailPattern.matcher(email).matches()) {
            System.out.println("Invalid email format. Please enter a valid email.");
        } else {
            break;
        }
    }

    users.add(new UserData(id, name, email));
    System.out.println("User added successfully!");
}


    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        System.out.println("\n--- Registered Users ---");
        for (UserData user : users) {
            System.out.println("ID: " + user.userId + " | Name: " + user.name + " | Email: " + user.email);
        }
    }

    public UserData findUserById(String userId) {
        for (UserData user : users) {
            if (user.userId.equals(userId)) {
                return user;
            }
        }
        return null;
    }
}
