package Addon;

import Interface.Coupon;
import ItemsPackage.PurchasedItems;

public class Coupon50OffAppleWatch implements Coupon {

    public Coupon50OffAppleWatch(){

    }

    @Override
    public boolean applies(PurchasedItems items) {
        return items.containsItem("2113");
    }

    @Override
    public String getLines() {
        return "Best Buy Promotion: $50 off Apple Watch Series 3\n"
                + "------------------------------------------------\n"
                + "Bring this receipt in for $50 off Apple Watch Series 3\n"
                + "Good for 30 days from issue of receipt";
    }
}
