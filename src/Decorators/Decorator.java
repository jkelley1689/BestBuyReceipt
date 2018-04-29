package Decorators;

import Interface.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;

    public Decorator(Receipt r){
        trailer = r;
    }

    protected void callTrailer(){
        trailer.printReceipt();
    }

    public abstract void printReceipt();
}
