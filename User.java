import java.util.LinkedList;

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

    public void addUser(java.util.Scanner scanner) {
        System.out.print("Enter User ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

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