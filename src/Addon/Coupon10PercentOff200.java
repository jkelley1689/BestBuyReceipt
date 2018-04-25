package Addon;
import Interface.Coupon;
import ItemsPackage.PurchasedItems;

public class Coupon10PercentOff200 implements Coupon {

    @Override
    public boolean applies(PurchasedItems items) {
        if(items.getTotalCost() > 100)
            return true;
        return false;
    }

    @Override
    public String getLines() {
        return "Thanks for being a loyal customer!\n"
                + "You have spent over $200 today\n"
                + "Qualifying you for a 10% discount on your next purchase";
    }
}
