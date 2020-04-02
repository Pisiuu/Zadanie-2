package RentalShop;
import java.time.*;
import java.util.Scanner;
import java.util.UUID;

public class ItemInfo {
    //atributes
    public UUID itemId;
    public String itemTitle;
    private LocalDate releaseDate; //biblioteka time
    public String author;
    private String publishingHouse;
    private float price;
    public boolean itemAvailability;
    public int amount;
    public int realRentalTime;
    public int rentalTime;
    private Scanner scan = new Scanner(System.in);;
    private boolean infoBool;
    ////private String className = this.getClass().getSimpleName();

    private RentalRules rules;

    public ItemInfo() {
        infoBool = false;
        realRentalTime = 0;
        itemTitle = "Constuctor";
        itemId = UUID.randomUUID();
        itemAvailability = false;
        releaseDate = LocalDate.now();
        author = "Constructor";
        publishingHouse = "Constructor";
        price = 0.00f;
        rules = new RentalRules();
        amount = 0;

    }

    public void rent() {
        rules.rent(this);
    }

    public void penalty() {
        rules.penalty(this);
    }

    public void displayInfo() {
        System.out.println("Title: " + itemTitle + "\n" +
                "Author: " + author + "\n" +
                "Publishing house: " + publishingHouse + "\n" +
                "In stock: " + amount);
    }

    public String[] askForInfo() {
        String[] array = new String[3];
        System.out.println("Title: ");
        itemTitle = scan.nextLine();
        array[0] = itemTitle;
        System.out.println("Author: ");
        author = scan.nextLine();
        array[1] = author;
        System.out.println("Publishing house: ");
        publishingHouse = scan.nextLine();
        array[2] = publishingHouse;
        while (!infoBool) {
            try {
                System.out.println("How many: ");
                amount = scan.nextInt();
                infoBool = true;
            } catch (Exception e) {
                System.out.println("It has to be a number!");
            }
        }
        return array;
    }



}
