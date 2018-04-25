package TaxComputationClasses;

import java.util.ArrayList;
import ItemsPackage.PurchasedItems;
import ReceiptPackage.Date;

public class MarylandTax extends TaxComputation {

    private ArrayList<String> taxDates = new ArrayList<>();
    private final double RATE = .06;
    private final String STATECODE;

    public MarylandTax(){
        STATECODE = "MD";
        initialize();
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
        return date.getMonth().equalsIgnoreCase("August") && taxDates.contains(date.getDay());
    }

    public String getStateCode(){
        return STATECODE;
    }

    private void initialize(){
        for(int i = 14; i < 22; i++){
            taxDates.add(Integer.toString(i));
        }
    }


}
