package Model;

import java.util.Date;
class ElectricityBill extends BillModel {
    private String electricitySupplier;
    private float electricityMeterUsage;

    public ElectricityBill(String subscriptionNumber, float billValue, Date billingDate, String electricitySupplier, float electricityMeterUsage) {
        super(subscriptionNumber, billValue, billingDate);
        this.electricitySupplier = electricitySupplier;
        this.electricityMeterUsage = electricityMeterUsage;
    }

    @Override
    public void viewBill() {
        System.out.println("Electricity Bill Details:");
        System.out.println("Subscription Number: " + getSubscriptionNumber());
        System.out.println("Bill Value: " + getBillValue());
        System.out.println("Billing Date: " + getBillingDate());
        System.out.println("Electricity Supplier: " + electricitySupplier);
        System.out.println("Electricity Meter Usage: " + electricityMeterUsage);
    }
}