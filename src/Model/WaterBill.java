package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class WaterBill extends BillModel {
    private String waterSupplier;
    private float waterMeterUsage;
    private static List<WaterBill> savedPayments = new ArrayList<>();
    private static List<WaterBill> waterBillDB = new ArrayList<>();

    public WaterBill(String subscriptionNumber, float billValue, Date billingDate, String waterSupplier, float waterMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.waterSupplier = waterSupplier;
        this.waterMeterUsage = waterMeterUsage;
    }

    public String getWaterSupplier() {
        return waterSupplier;
    }

    public float getWaterMeterUsage() {
        return waterMeterUsage;
    }
    public void savePayment() {
        WaterBill paymentCopy = new WaterBill(subscriptionNumber, billValue, billingDate, waterSupplier, waterMeterUsage);
        savedPayments.add(paymentCopy);
    }

    public static List<WaterBill> getSavedPayments() {
        return savedPayments;
    }
    public static List<WaterBill> getWaterBillDB() {return waterBillDB;}

    static {
        // Example initialization of WaterBill payments
        WaterBill waterBill = new WaterBill("789012", 75.0f, new Date(), "WaterSupplier1", 45.2f);
        waterBillDB.add(waterBill);
    }
}