package ItemsPackage;

import java.util.ArrayList;

public class AvailableItems {

    private ArrayList<StoreItem> avalItems;
    private int currentIndex = 0;

    public AvailableItems(){
        avalItems= new ArrayList<>();
        populate();
    }

    public void populate(){
        avalItems.add(new StoreItem("132","Samsung S9 Midnight Black 64 GB","719.99"));
        avalItems.add((new StoreItem("2113","Apple Iphone X White 128 GB","1199.99")));
        avalItems.add(new StoreItem("2111","Apple iWatch Series 3 Non-Celluar","349.99"));
        avalItems.add(new StoreItem("3124","Sony Vizio 72 inch 4k ULED","799.99"));
        avalItems.add(new StoreItem("1004","Beats by Dre Sport Earbuds","79.99"));
    }

    public boolean hasNext(){
        if(currentIndex < avalItems.size() && avalItems.get(currentIndex) != null)
            return true;
        else
            return false;
    }

    public StoreItem next(){
        StoreItem item = avalItems.get(currentIndex);
        currentIndex++;
        return item;
    }

    public int getSize(){
        return avalItems.size();
    }

    public StoreItem getItem(int index){
        return avalItems.get(index);
    }


}
