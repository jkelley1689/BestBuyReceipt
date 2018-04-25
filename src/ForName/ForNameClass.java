package ForName;

import java.util.HashMap;

import TaxComputationClasses.*;

public class ForNameClass {

    private HashMap taxCompClasses = new HashMap<String,Class>();

    public ForNameClass(){
        Class taxClass;

        try{
            taxClass = Class.forName("TaxComputationClasses.MarylandTax");

            populateTaxCompHashTable();

            taxClass = (Class) taxCompClasses.get("MD");

            TaxComputation t = (TaxComputation)taxClass.newInstance();
            System.out.println(t.getRATE());
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
    }

    private void populateTaxCompHashTable(){
        String pkg = "TaxComputationClasses.";

        try{
            taxCompClasses.put("MD",Class.forName(pkg + "MarylandTax"));
            taxCompClasses.put("CA",Class.forName(pkg + "CaliforniaTax"));
            taxCompClasses.put("MA",Class.forName(pkg + "MassachusettsTax"));
        }
        catch (ClassNotFoundException e){
            System.out.println("Tax Computation Class Error");
        }
    }
}
