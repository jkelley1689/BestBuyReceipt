package Decorators;

import Interface.AddOn;
import Interface.Receipt;

public class PostDecorator extends Decorator {

    AddOn a;
    //Interface.Receipt r;

    public PostDecorator(Receipt r, AddOn a){
        super(r);
        this.a = a;
    }

    @Override
    public void printReceipt() {
        callTrailer();
        System.out.println(a.getLines() + "\n");
    }
}
