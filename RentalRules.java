package RentalShop;


import java.util.Scanner;

import static RentalShop.RentalShop.inventory;

public class RentalRules {

    private Scanner scan = new Scanner(System.in);
    private int penalty;
    private String rentedItem;
    private boolean bool;



    public RentalRules() {
        penalty = 0;
        bool = false;
        rentedItem = "Constructor";
    }

    public void rent(ItemInfo itemInfo) {



            if (itemInfo.itemAvailability == true) {
                System.out.println("How many days?");
                itemInfo.rentalTime = scan.nextInt();
                itemInfo.realRentalTime = itemInfo.rentalTime;
                if (itemInfo.rentalTime > 7 || itemInfo.rentalTime == 0) {
                    System.out.println("You can rent up to 7 days");
                } else {
                    System.out.printf("You have rented ");
                    System.out.printf(itemInfo.getClass().getSimpleName());
                    System.out.printf(" titled " + itemInfo.itemTitle + " for " + itemInfo.rentalTime + " days" + ".\n");
                    itemInfo.amount = itemInfo.amount - 1;
                    if (itemInfo.amount == 0) {
                        itemInfo.itemAvailability = false;
                        System.out.println("This was the last " + itemInfo.getClass().getSimpleName() + " titled " + itemInfo.itemTitle);
                    }
                }
            } else System.out.println("Item unavailble");






    }

    public void penalty(ItemInfo itemInfo) {
        if (itemInfo.realRentalTime > itemInfo.rentalTime) {
            penalty = (itemInfo.realRentalTime - itemInfo.rentalTime)*20;
            System.out.printf("Delay! You have to pay " + penalty + " $");
        }
        else {
            System.out.printf("No penalty - returned on time.");
        }

    }
}
