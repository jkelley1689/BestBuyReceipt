package TaxComputationClasses;
import ItemsPackage.PurchasedItems;
import ReceiptPackage.Date;

public class CaliforniaTax extends TaxComputation {

    private final double RATE = .0725;
    private final String STATECODE = "CA";

    public double computeTax(PurchasedItems items, Date date){
        return items.getTotalCost() * RATE;
    }

    @Override
    public boolean taxHoliday(Date date) {
        return false;
    }

    @Override
    public double getRATE() {
        return RATE;
    }
    @Override
    public String getStateCode() {
        return STATECODE;
    }
}
