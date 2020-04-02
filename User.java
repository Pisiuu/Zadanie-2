package RentalShop;


import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class User {

    public String username;
    private String password;
    private String[] rentedItems = new String[5];
    private Scanner scan = new Scanner(System.in);
    public UUID userID;

    public User() {
        username = "Constructor";
        password = "Constructor";
    }

    public void signIn() {
        userID = UUID.randomUUID();
        System.out.println("Username: ");
        username = scan.nextLine();
        do {
            if (username.contains("") && username.length() <= 10) {
                System.out.println("Correct username");
                break;
            } else {
                System.out.println("Incorrect username, max 10 characters and must contain '!'");
            }
        } while (true);
        System.out.println("Password: ");
        password = scan.nextLine();

    }

    public boolean logIn() {
        boolean bool;
        do {
        System.out.println("Password: ");
        var p = scan.nextLine();
        if (p.equals(password)) {
            System.out.printf("Correct password.\n");
            return true;
        } else System.out.println("Wrong password.\n");
        } while (bool = true);

        return false;
    }

    public void displayInfo() {

            System.out.println("Username: " + username);
            System.out.println("Press '1' to change username\n" + "Press '2' to change password");

    }
}
