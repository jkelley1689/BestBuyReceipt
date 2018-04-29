package ItemsPackage;

import java.util.ArrayList;

public class PurchasedItems {

    private ArrayList<StoreItem> items;
    private int currentIndex;

    public PurchasedItems(){
        items = new ArrayList<>();
    }

    public void addItem(StoreItem item){
        items.add(item);
    }

    public double getTotalCost(){
        double totalCost = 0;
        for(int i = 0;i < items.size();i++){
            totalCost = totalCost + Double.parseDouble(items.get(i).getItemPrice());
        }
        return totalCost;
    }

    public boolean containsItem(String itemCode){

        for(int i = 0;i < items.size();i++){
            if(items.get(i).getItemCode().equals(itemCode))
                return true;
        }
        return false;
    }

    public boolean hasNext(){
        if(currentIndex < items.size() && items.get(currentIndex) != null)
            return true;
        else
            return false;
    }

    public StoreItem next(){
        StoreItem item = items.get(currentIndex);
        currentIndex++;
        return item;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
