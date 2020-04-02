package RentalShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserBase {
    private List<User> users;
    private Scanner scan = new Scanner(System.in);



    public UserBase() {
        users = new ArrayList<User>();
    }

    public UUID createNewUser() {
        User user = new User();
        user.signIn();
        users.add(user);
        return user.userID;
    }

    private User findByUsername(String username) { //popraw
        return users.stream().filter((i) -> i.username.equals(username)).findFirst().orElse(null);
    }

    public UUID logIn(String username) {
        User user = new User();
        user = search(username);
        if(user !=null) {
            user.logIn();
            System.out.println("Logged in!");
            return user.userID;
        }
        return null;
    }




    public User search(String username) {

        var user = findByUsername(username);
        if (user != null) {
            System.out.printf(user.getClass().getSimpleName());
            System.out.printf(" named ");
            System.out.printf(user.username);
            System.out.printf(" exists.\n");
            return user;
        } else {
            System.out.println("No such user in data base.");
        }
        return null;
    }
}
