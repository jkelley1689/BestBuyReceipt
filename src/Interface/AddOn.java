package Interface;

import ItemsPackage.PurchasedItems;

public interface AddOn {

    boolean applies(PurchasedItems items);
    String getLines();
}
