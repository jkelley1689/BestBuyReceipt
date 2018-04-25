package Addon;

import Interface.Rebate;
import ItemsPackage.PurchasedItems;

public class Rebate2113 implements Rebate {

    @Override
    public boolean applies(PurchasedItems items) {
        return items.containsItem("3124");
    }

    @Override
    public String getLines() {
        return "Mail-in Interface.Rebate for Item #3124\n"
                + "$100 Interface.Rebate\n"
                + "Name:____________\n"
                + "Address:______________\n"
                + "Mail to: Best Buy Rebates, P.O. Box 14500, Orlando, Fl";
    }
}
