package RentalShop;
import java.util.*;

public class Inventory {

    private List<ItemInfo> items;
    private String choice;


    private Scanner scan = new Scanner(System.in);
    private RentalRules rentalRules;

    public Inventory() {
        items = new ArrayList<ItemInfo>();
        rentalRules = new RentalRules();
    }

    public UUID makeNewItem() {

        ItemInfo newItem = null;
        do {
            System.out.println("\n---------------------------------------" + "\nWhat do you want to add into inventory?" + "\n---------------------------------------");
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
                    newItem = new Book();
                    System.out.println("You have created a " + newItem.getClass().getSimpleName() + " item.");
                    newItem.askForInfo();
                break;
                case "2":
                    newItem = new Movie();
                    System.out.println("You have created a " + newItem.getClass().getSimpleName() + " item.");
                    newItem.askForInfo();
                    break;
                case "3":
                    newItem = new Audiobook();
                    System.out.println("You have created an " + newItem.getClass().getSimpleName() + " item.");
                    newItem.askForInfo();
                break;
                case "4":
                    newItem = new Ebook();
                    System.out.println("You have created an " + newItem.getClass().getSimpleName() + " item.");
                    newItem.askForInfo();
                break;
                case "5":
                    newItem = new MusicalCD();
                    System.out.println("You have added a " + newItem.getClass().getSimpleName());
                    newItem.askForInfo();
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

        newItem.itemAvailability = true;
        items.add(newItem);

        return newItem.itemId;
    }

    private ItemInfo findByID(UUID id) {
        return items.stream().filter((i) -> i.itemId == id).findFirst().orElse(null);
    }


    public void rent(UUID id) {

        var item = findByID(id);

        if (item != null) {
            item.rent();
        }else {
            System.out.println("No item in stock");
        }
    }

    private ItemInfo findByTitle(String title) { //popraw
        return items.stream().filter((i) -> i.itemTitle.equals(title)).findFirst().orElse(null);
    }


    public UUID search(String title) {

        var item = findByTitle(title);
        if (item != null && item.itemAvailability == true) {
                System.out.printf(item.getClass().getSimpleName());
                System.out.println(" in stock");
                item.displayInfo();
            return item.itemId;
            } else {
            System.out.println("No item in stock");
        }
        return null;
        }

}
