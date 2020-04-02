package RentalShop;

public class RentalShop {

    public static Inventory inventory;
    public static UserBase userBase;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";





    public static void main(String[] args) {

        inventory = new Inventory();
        userBase = new UserBase();

        new Menu();


    }

}
