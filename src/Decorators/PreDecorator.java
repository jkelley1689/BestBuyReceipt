package Decorators;


import Interface.AddOn;
import Interface.Receipt;

public class PreDecorator extends Decorator {

    AddOn a;
    //Interface.Receipt r;

    public PreDecorator(Receipt r, AddOn a){
        super(r);
        this.a = a;
    }

    public void printReceipt(){
        System.out.println(a.getLines() + "\n");
        callTrailer();
    }
}
