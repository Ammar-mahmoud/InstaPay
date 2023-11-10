package Model;

import java.util.Date;
class WaterBill extends BillModel {
    private String waterSupplier;
    private float waterMeterUsage;

    public WaterBill(String subscriptionNumber, float billValue, Date billingDate, String waterSupplier, float waterMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.waterSupplier = waterSupplier;
        this.waterMeterUsage = waterMeterUsage;
    }
    @Override
    public void viewBill() {
        System.out.println("Water Bill Details:");
        System.out.println("Subscription Number: " + getSubscriptionNumber());
        System.out.println("Bill Value: " + getBillValue());
        System.out.println("Billing Date: " + getBillingDate());
        System.out.println("Water Supplier: " + waterSupplier);
        System.out.println("Water Meter Usage: " + waterMeterUsage);
    }
}