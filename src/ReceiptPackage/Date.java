package ReceiptPackage;

public class Date {
    private String day;
    private String month;
    private String year;

    public Date(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void printDate(){
        System.out.println(month +  " " + day + " " + year);
    }
}
