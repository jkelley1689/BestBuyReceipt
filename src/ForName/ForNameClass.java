package ForName;

import java.util.HashMap;

import TaxComputationClasses.*;

public class ForNameClass {

    private HashMap taxCompClasses = new HashMap<String,Class>();
    private TaxComputation t;

    public ForNameClass(){
            populateTaxCompHashTable();
    }

    public TaxComputation getTCClass(String stateCode){
        Class taxClass;
        try{
            taxClass = Class.forName("TaxComputationClasses.MarylandTax");

            taxClass = (Class) taxCompClasses.get(stateCode);

            t = (TaxComputation)taxClass.newInstance();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        catch(InstantiationException e){
            System.out.println("Class Instantiation Error");
        }
        catch (IllegalAccessException e) {
            System.out.println("Illegal Access Error");
        }
        return t;
    }

    private void populateTaxCompHashTable(){
        String pkg = "TaxComputationClasses.";

        try{
            taxCompClasses.put("MD",Class.forName(pkg + "MarylandTax"));
            taxCompClasses.put("CA",Class.forName(pkg + "CaliforniaTax"));
            taxCompClasses.put("MA",Class.forName(pkg + "MassachusettsTax"));
            taxCompClasses.put("VA",Class.forName(pkg + "VirginiaTax"));
            taxCompClasses.put("DE",Class.forName(pkg + "DelawareTax"));
        }
        catch (ClassNotFoundException e){
            System.out.println("Tax Computation Class Error");
        }
    }
}
