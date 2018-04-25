package ItemsPackage;

public class StoreItem {

    private String itemCode;
    private String itemDescription;
    private String itemPrice;

    public StoreItem(String itemCode,String itemDescription, String itemPrice){
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }
}
