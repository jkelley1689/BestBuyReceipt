package Decorators;

import Interface.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;

    public Decorator(Receipt r){
        trailer = r;
        //addOn = a;
    }

    protected void callTrailer(){
        trailer.printReceipt();
        //System.out.println(a.getLines());
    }

    public abstract void printReceipt();
}
