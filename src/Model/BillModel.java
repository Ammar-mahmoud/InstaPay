package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BillModel {
    protected String subscriptionNumber;
    protected float billValue;
    protected Date billingDate;
    private static List<BillModel> BillDB = new ArrayList<>();


    public BillModel(String subscriptionNumber, float billValue, Date billingDate) {
        this.subscriptionNumber = subscriptionNumber;
        this.billValue = billValue;
        this.billingDate = billingDate;
    }

    public static List<BillModel> getBillDB() {
        return BillDB;
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }
    public float getBillValue() {
        return billValue;
    }
    public Date getBillingDate() {
        return billingDate;
    }
    public abstract void savePayment();


    static {
        // Example initialization of Bill DB
        WaterBill waterBill = new WaterBill("789012", 75.0f, new Date(), "WaterSupplier1", 45.2f);
        BillDB.add(waterBill);
        ElectricityBill electricityBill = new ElectricityBill("345678", 100.0f, new Date(), "ElectricitySupplier1", 60.8f);
        BillDB.add(electricityBill);
        GasBill gasBill = new GasBill("123456", 50.0f, new Date(), "GasSupplier1", 30.5f);
        BillDB.add(gasBill);
    }

}
