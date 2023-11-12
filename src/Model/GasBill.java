package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class GasBill extends BillModel {
    private String gasSupplier;
    private float gasMeterUsage;
    private static List<GasBill> savedPayments = new ArrayList<>();

    public GasBill(String subscriptionNumber, float billValue, Date billingDate, String gasSupplier, float gasMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.gasSupplier = gasSupplier;
        this.gasMeterUsage = gasMeterUsage;
    }


    public String getGasSupplier() {
        return gasSupplier;
    }

    public float getGasMeterUsage() {
        return gasMeterUsage;
    }
    public void savePayment() {
        //System.out.println("Saving gas bill payment...");
        // Create a copy of the current GasBill with all details
        GasBill paymentCopy = new GasBill(subscriptionNumber, billValue, billingDate, gasSupplier, gasMeterUsage);
        savedPayments.add(paymentCopy);
        //System.out.println("Gas bill payment saved successfully.");
    }

    public static List<GasBill> getSavedPayments() {
        return savedPayments;
    }
}