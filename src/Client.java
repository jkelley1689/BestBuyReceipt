import Interface.Receipt;
import ItemsPackage.*;
import ReceiptPackage.*;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        //menu();
        //menuChoice();
        testDriver();


    }

    public static void menu(){
        System.out.println("Please choose one of the following");
        System.out.println("1. Start new receipt");
        System.out.println("2. Show Available items");
        System.out.println("3. Add items");
        System.out.println("4. Display receipt");
        System.out.println("5. Exit");
    }

    public static void testDriver() throws IOException{
        PurchasedItems purchasedItems = new PurchasedItems();
        AvailableItems availableItems = new AvailableItems();
        ReceiptFactory receipt = new ReceiptFactory();
        Date date = new Date("15","August","2018");
        purchaseItem(availableItems,purchasedItems);
        Receipt finalReceipt = receipt.getReceipt(purchasedItems,date);
        finalReceipt.printReceipt();
    }

    public static void menuChoice() throws IOException{
        PurchasedItems purchasedItems = new PurchasedItems();
        AvailableItems availableItems = new AvailableItems();
        ReceiptFactory receipt = new ReceiptFactory();
        Date date = new Date("21","Dec","2018");
        Scanner console = new Scanner(System.in);
        System.out.println(">>");
        int choice = console.nextInt();
        while(choice != 5){
            switch (choice) {
                case 1:
                    break;
                case 2:
                    displayAvalItems(availableItems);
                    break;
                case 3:
                    purchaseItem(availableItems,purchasedItems);
                    break;
                case 4:
                     Receipt finalReceipt = receipt.getReceipt(purchasedItems,date);
                     finalReceipt.printReceipt();
                    break;
            }
            menu();
            System.out.println(">>");
            choice = console.nextInt();
        }
        System.out.println("Exiting");
    }

    public static void displayAvalItems(AvailableItems availableItems){
        StoreItem item;
        while(availableItems.hasNext()){
            item = availableItems.next();
            System.out.println("Item Number: " + item.getItemCode());
            System.out.println("Item Description: " + item.getItemDescription());
            System.out.println("Item Price: " + item.getItemPrice());
            System.out.println();
        }
    }

    public static void purchaseItem(AvailableItems availableItems,PurchasedItems purchasedItems){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the item number you wish to purchase");
        System.out.println(">>");
        String itemNum = "2113"; //remove these next two lines for finished product
        String itemNum2 = "3124";
        //String itemNum = console.next();
        purchasedItems.addItem(findItem(availableItems,itemNum));
        purchasedItems.addItem(findItem(availableItems,itemNum2));
    }

    public static StoreItem findItem(AvailableItems availableItems,String itemNum) {
        StoreItem item;
        for (int i = 0; i < availableItems.getSize(); i++) {
            if (availableItems.getItem(i).getItemCode().equals(itemNum)) {
                item = availableItems.getItem(i);
                return item;
            }
        }
        return null;
    }

}