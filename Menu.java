package RentalShop;
import java.util.Scanner;
import java.util.UUID;

import static RentalShop.RentalShop.*;


public class Menu {
    private String choice;
    private Scanner scan = new Scanner(System.in);
    private String choiceInventory;
    private UUID id;
    private String title;
    private String username;

    private void inventoryMenu() {
        do {
            System.out.println("---------" + "\nInventory" + "\n---------");
        System.out.println("1. Add item to inventory\n" +
                "2. Search\n" +
                "3. Rent an item\n" +
                "4. Rented items\n" +
                "5. Exit\n");
        System.out.println("Choose: ");
        this.choiceInventory = scan.nextLine();

            switch (choiceInventory) {
                case "1":
                    inventory.makeNewItem();
                    break;
                case "2":
                    System.out.println("Write title: ");
                    var title = scan.nextLine();
                    inventory.search(title);
                    break;
                case "3":
                    id = inventoryMenuRent();
                    inventory.rent(id);
                    break;
                case "4":
                    System.out.println(ANSI_RED + "Still in development" + ANSI_RESET);
                    break;
                case "5":
                    break;
                default:
                    choiceInventory = "0";
                    System.out.println("Choose again!");
                    break;
            }

        } while(Integer.parseInt(choiceInventory) != 5);
    }

    private UUID inventoryMenuRent() {
        do {
            choice = "0";
            System.out.println("\n----------------------------------" + "\nWhat do you want to rent?" + "\n----------------------------------");
            System.out.println("1. Book\n" +
                    "2. Movie\n" +
                    "3. Audiobook\n" +
                    "4. Ebook\n" +
                    "5. Musical CD\n" +
                    "6. Exit\n");
            System.out.println("Choice: ");
            this.choice = scan.nextLine();
            switch (this.choice) {
                case "1":
                    System.out.println("You have choosen a Book item");
                    System.out.println("Which book?" + "\nTitle: ");
                    title = scan.nextLine();
                    id = inventory.search(title);// pobieraj 3 wartosci z item ifno
                    choice = "6";
                    break;
                case "2":
                    System.out.println("You have choosen a Movie item");
                    System.out.println("Which movie?" + "\nTitle: ");
                    title = scan.nextLine();
                    id = inventory.search(title);
                    choice = "6";
                    break;
                case "3":
                    System.out.println("You have choosen an Audiobook item.");
                    System.out.println("Which audiobook? " + "\nTitle: ");
                    title = scan.nextLine();
                    id = inventory.search(title);
                    choice = "6";
                    break;
                case "4":
                    System.out.println("You have choosen an Ebook item.");
                    System.out.println("Which ebook?" + "\nTitle: ");
                    title = scan.nextLine();
                    id = inventory.search(title);
                    choice = "6";
                    break;
                case "5":
                    System.out.println("You have choosen a MusicalCD item.");
                    System.out.println("Which muscial CD?" + "\nTitle: ");
                    title = scan.nextLine();
                    id = inventory.search(title);
                    choice = "6";
                    break;
                case "6":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Choose again!");
                    this.choice = "0";
                    break;

            }
        } while (Integer.parseInt(choice) !=6);
        return id;
    }

    public Menu() {
        username = null;
        this.choice = "0";
        this.choiceInventory = "0";
        do {
            System.out.println("-----\n" + "Menu\n" + "-----");
            System.out.println("1. Sign in \n" +
                    "2. Log in \n" +
                    "3. Account info \n" +
                    "4. Inventory \n" +
                    "5. Cashier \n" +
                    "6. Exit \n");
            System.out.println("Choose: ");
            this.choice = scan.nextLine();
            switch(this.choice){
                case "1":
                    userBase.createNewUser();
                    break;
                case "2":
                    System.out.println("Username:");
                    username = scan.nextLine();
                    var id = userBase.logIn(username);
                    break;
                case "3":
                    User user = userBase.search(username);
                    if (user != null) {
                        user.displayInfo();
                    } else System.out.println("You have to be logged on.");
                    System.out.println(ANSI_RED + "Still in development" + ANSI_RESET);
                    break;
                case "4":
                    inventoryMenu();
                    break;
                case "5":
                    //klasa kasa z rental rules
                    System.out.println(ANSI_RED + "Still in development" + ANSI_RESET);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Choose again!");
                    choice = "0";
                    break;

            }

        } while(Integer.parseInt(choice) != 6);


    }



}
