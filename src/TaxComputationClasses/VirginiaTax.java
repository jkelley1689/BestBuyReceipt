package TaxComputationClasses;

import ItemsPackage.PurchasedItems;
import ReceiptPackage.Date;

import java.util.ArrayList;

public class VirginiaTax extends TaxComputation{

    private ArrayList<String> taxDates = new ArrayList<>();
    private final double RATE = .053;
    private final String STATECODE;

    public VirginiaTax(){
        STATECODE = "VA";
    }

    public double computeTax(PurchasedItems items, Date date){
        if(taxHoliday(date))
            return 0;
        else
            return items.getTotalCost() * RATE;
    }

    public double getRATE() {
        return RATE;
    }

    public boolean taxHoliday(Date date){
        return date.getMonth().equalsIgnoreCase("Aug") ||
                date.getMonth().equalsIgnoreCase("May") ||
                date.getMonth().equalsIgnoreCase("Oct");
    }

    public String getStateCode(){
        return STATECODE;
    }

}
