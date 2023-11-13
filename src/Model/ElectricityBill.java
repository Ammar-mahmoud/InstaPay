package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ElectricityBill extends BillModel {
    private String electricitySupplier;
    private float electricityMeterUsage;
    private static List<ElectricityBill> savedPayments = new ArrayList<>();
    private static List<ElectricityBill> electricityBillDB= new ArrayList<>();


    public ElectricityBill(String subscriptionNumber, float billValue, Date billingDate, String electricitySupplier, float electricityMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.electricitySupplier = electricitySupplier;
        this.electricityMeterUsage = electricityMeterUsage;
    }
    public String getElectricitySupplier(){
        return electricitySupplier;
    }

    public float getElectricityMeterUsage() {
        return electricityMeterUsage;
    }
    public void savePayment() {
        ElectricityBill paymentCopy = new ElectricityBill(subscriptionNumber, billValue, billingDate, electricitySupplier, electricityMeterUsage);
        savedPayments.add(paymentCopy);
    }

    public static List<ElectricityBill> getSavedPayments() {
        return savedPayments;
    }
    public static List<ElectricityBill> getElectricityBillDB() {return electricityBillDB;}


    static {
        // Example initialization of ElectricityBill payments
        ElectricityBill electricityBill = new ElectricityBill("345678", 100.0f, new Date(), "ElectricitySupplier1", 60.8f);
        electricityBillDB.add(electricityBill);
    }

}