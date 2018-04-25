package Addon;

import Interface.SecondaryHeader;
import ItemsPackage.PurchasedItems;

public class HolidayGreeting implements SecondaryHeader {

    @Override
    public boolean applies(PurchasedItems items) {
        return true;
    }

    @Override
    public String getLines() {
        return "Happy Holidays from Best Buy!";
    }
}
