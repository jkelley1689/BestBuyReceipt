package ReceiptPackage;

import Addon.*;
import TaxComputationClasses.*;
import ItemsPackage.*;
import Interface.*;
import Decorators.*;
import ForName.ForNameClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptFactory{

   StoreHeader storeHeader;
   //private ArrayList<TaxComputation> taxComputationsObjs = new ArrayList<>();
   private ForNameClass taxComputationsObjs = new ForNameClass();
   private ArrayList<AddOn> addOns = new ArrayList<>();
   private String[] arr;
   private Receipt receipt;
   private TaxComputation tc;


   public ReceiptFactory() throws IOException{
       //populateTaxArray();
       populateAddOns();
       saveStoreHeader();
       //tc = taxComputationsObjs.get(findIndex());
       tc = taxComputationsObjs.getTCClass(storeHeader.getStateCode());
   }

   public Receipt getReceipt(PurchasedItems items, Date date){
       receipt = new BasicReceipt(items,date);
       ((BasicReceipt) receipt).setStoreHeader(storeHeader);
       //((BasicReceipt) receipt).setTc(tc);
       ((BasicReceipt) receipt).setTc(tc);
       checkForAddOns(items);
       //addDecorators();
       return receipt;
   }

   /*public void populateTaxArray(){
       taxComputationsObjs.add(new MarylandTax());
       taxComputationsObjs.add(new MassachusettsTax());
       taxComputationsObjs.add(new CaliforniaTax());
   }*/

   public void populateAddOns(){
       addOns.add(new HolidayGreeting());
       addOns.add(new Coupon50OffAppleWatch());
       addOns.add(new Rebate2113());
       addOns.add(new Coupon10PercentOff200());
   }

   /*public int findIndex(){
       for(int i = 0;i < taxComputationsObjs.size();i++){
           if(taxComputationsObjs.get(i).getStateCode().equals(storeHeader.getStateCode()))
               return i;
       }
       return -1;
   }*/

   public void readConfigFile() throws IOException{
       List<String> fileList = new ArrayList<>();
       Scanner inFile = new Scanner(new File("/Users/justinkelley/Documents/Cosc436/BestBuyReceipt/src/config.txt"));
       String token;
       while(inFile.hasNext()){
           token = inFile.nextLine();
           fileList.add(token);
       }
       inFile.close();
       arr = fileList.toArray(new String[0]);
   }

   public void saveStoreHeader() throws IOException{
       readConfigFile();
       storeHeader = new StoreHeader(arr[0],arr[1],arr[2],arr[3],arr[4]);
   }

   public void checkForAddOns(PurchasedItems items){
       for(int i =0;i < addOns.size();i++){
           if(addOns.get(i).applies(items)) {
               if (addOns.get(i) instanceof SecondaryHeader)
                   receipt = new PreDecorator(receipt,addOns.get(i));
                   //preDecorator = new Decorators.PreDecorator(receipt,addOns.get(i));
               else
                   receipt = new PostDecorator(receipt,addOns.get(i));
                   //postDecorator = new Decorators.PostDecorator(receipt,addOns.get(i));
           }
       }
   }
}
