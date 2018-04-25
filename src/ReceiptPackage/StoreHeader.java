package ReceiptPackage;

public class StoreHeader {
    private String streetAddr;
    private String zipCode;
    private String stateCode;
    private String phoneNum;
    private String storeNum; // e.g. #1004

    public StoreHeader(String streetAddr,String zipCode,String stateCode,String phoneNum,String storeNum){
        this.streetAddr = streetAddr;
        this.zipCode = zipCode;
        this.stateCode = stateCode;
        this.phoneNum = phoneNum;
        this.storeNum = storeNum;
    }

    public String getStateCode(){
        return stateCode;
    }

    public String toString(){
        return "Best Buy                                       " + storeNum + "\n"
                + streetAddr + "," + zipCode + "               " + phoneNum + "\n";
    }
}
