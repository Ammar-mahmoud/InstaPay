package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class WaterBill extends BillModel {
    private String waterSupplier;
    private float waterMeterUsage;
    private static List<WaterBill> savedPayments = new ArrayList<>();

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
        //System.out.println("Saving water bill payment...");
        // Create a copy of the current WaterBill with all details
        WaterBill paymentCopy = new WaterBill(subscriptionNumber, billValue, billingDate, waterSupplier, waterMeterUsage);
        savedPayments.add(paymentCopy);
        //System.out.println("Water bill payment saved successfully.");
    }

    public static List<WaterBill> getSavedPayments() {
        return savedPayments;
    }
}