package TaxComputationClasses;

import ItemsPackage.PurchasedItems;
import ReceiptPackage.Date;

public class DelawareTax extends TaxComputation{
    private final double RATE = .00;
    private final String STATECODE = "DE";

    public double computeTax(PurchasedItems items, Date date){
        return 0.00;
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


