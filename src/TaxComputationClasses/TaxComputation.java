package TaxComputationClasses;
import ItemsPackage.PurchasedItems;
import ReceiptPackage.Date;

public abstract class TaxComputation {

    public abstract double computeTax(PurchasedItems items, Date date);
    public abstract boolean taxHoliday(Date date);
    public abstract String getStateCode();
    public abstract double getRATE();
}
