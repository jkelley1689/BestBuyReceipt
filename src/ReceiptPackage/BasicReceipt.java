package ReceiptPackage;

import Interface.Receipt;
import TaxComputationClasses.TaxComputation;
import ItemsPackage.PurchasedItems;
import ItemsPackage.StoreItem;

public class BasicReceipt implements Receipt {

    private StoreHeader storeHeader;
    private TaxComputation tc;
    private Date date;
    private PurchasedItems items;

    public BasicReceipt(PurchasedItems items, Date date){
        this.items = items;
        this.date = date;
    }

    public void setStoreHeader(StoreHeader h){
        this.storeHeader = h;
    }

    public void setTc(TaxComputation tc) {
        this.tc = tc;
    }

    @Override
    public void printReceipt(){
        StoreItem item;
        double preTaxCost = items.getTotalCost();
        double tax = tc.computeTax(items, date);
        double total = preTaxCost + tax;
        System.out.println(storeHeader.toString());
        date.printDate();
        while(items.hasNext()){
            item = items.next();
            System.out.println("Item Number: " + item.getItemCode());
            System.out.println("Item Description: " + item.getItemDescription());
            System.out.println("Item Price: " + item.getItemPrice());
            System.out.println();
        }
        System.out.println("Cost                           " + "$" + preTaxCost);
        System.out.printf(tc.getStateCode() + " Sales Tax " + tc.getRATE() + "              " + "$" + "%.2f",tax );
        System.out.println();
        System.out.printf("Total Sale                     " + "$" + "%.2f",total);
        System.out.println("\n\n\n");
    }

}
