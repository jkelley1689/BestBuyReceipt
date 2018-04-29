import Interface.Receipt;
import ItemsPackage.*;
import ReceiptPackage.*;

import java.io.IOException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        menuChoice();


    }

    public static void menu(){
        System.out.println("Please choose one of the following");
        System.out.println("1. Start new receipt");
        System.out.println("2. Show Available items");
        System.out.println("3. Add items");
        System.out.println("4. Display receipt");
        System.out.println("5. Exit");
    }


    //This commented out section was use only for testing purposes, not part of the actual program
    /*public static void testDriver() throws IOException{
        PurchasedItems purchasedItems = new PurchasedItems();
        AvailableItems availableItems = new AvailableItems();
        ReceiptFactory receipt = new ReceiptFactory();
        Date date = new Date("15","Oct","2018");
        purchaseItem(availableItems,purchasedItems);
        Receipt finalReceipt = receipt.getReceipt(purchasedItems,date);
        finalReceipt.printReceipt();
    }*/

    public static void menuChoice() throws IOException{
        Scanner console = new Scanner(System.in);
        PurchasedItems purchasedItems = new PurchasedItems();
        AvailableItems availableItems = new AvailableItems();
        ReceiptFactory receipt = new ReceiptFactory();

        //Create date object from user input
        System.out.println("Please enter current date");
        System.out.println("Month: (e.g. Jan,Oct,Dec) >>");
        String month = console.next();
        System.out.println("Day: >>");
        String day = console.next();
        System.out.print("Year: >>");
        String year = console.next();
        Date date = new Date(day,month,year);

        menu(); //Display user menu
        System.out.println(">>");
        int choice = console.nextInt();
        while(choice != 5){
            switch (choice) {
                case 1:
                    receipt = new ReceiptFactory(); //erases old receipt and starts a new one
                    purchasedItems = new PurchasedItems();
                    break;
                case 2:
                    displayAvalItems(availableItems); //display items aval to purchase
                    break;
                case 3:
                    purchaseItem(availableItems,purchasedItems); //add items to purchasedItems, to be put on receipt
                    break;
                case 4:
                    if(purchasedItems.isEmpty()){
                        System.out.println("You have not chosen any items to purchase!\n\n");
                    }
                    else {
                        Receipt finalReceipt = receipt.getReceipt(purchasedItems, date); //creates receipt and returns its to the user
                        finalReceipt.printReceipt();
                    }
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
        String itemNum = console.next();
        purchasedItems.addItem(findItem(availableItems,itemNum));

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