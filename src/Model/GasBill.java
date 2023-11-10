package Model;

import java.util.Date;
class GasBill extends BillModel {
    private String gasSupplier;
    private float gasMeterUsage;

    public GasBill(String subscriptionNumber, float billValue, Date billingDate, String gasSupplier, float gasMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.gasSupplier = gasSupplier;
        this.gasMeterUsage = gasMeterUsage;
    }

    @Override
    public void viewBill() {
        System.out.println("Gas Bill Details:");
        System.out.println("Subscription Number: " + getSubscriptionNumber());
        System.out.println("Bill Value: " + getBillValue());
        System.out.println("Billing Date: " + getBillingDate());
        System.out.println("Gas Supplier: " + gasSupplier);
        System.out.println("Gas Meter Usage: " + gasMeterUsage);
    }
}