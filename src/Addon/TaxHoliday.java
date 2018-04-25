package Addon;

import Interface.SecondaryHeader;
import ItemsPackage.PurchasedItems;

public class TaxHoliday implements SecondaryHeader {

    public TaxHoliday(){

    }

    @Override
    public boolean applies(PurchasedItems items) {
        return true;
    }

    @Override
    public String getLines() {
        return "Enjoy tax free shopping this week!";
    }
}
