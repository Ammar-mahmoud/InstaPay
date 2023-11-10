package Model;

import java.util.Date;
public abstract class BillModel {
    protected String subscriptionNumber;
    private float billValue;
    private Date billingDate;

    public BillModel(String subscriptionNumber, float billValue, Date billingDate) {
        this.subscriptionNumber = subscriptionNumber;
        this.billValue = billValue;
        this.billingDate = billingDate;
    }

    public abstract void viewBill();

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }
    public float getBillValue() {
        return billValue;
    }
    public Date getBillingDate() {
        return billingDate;
    }
    static {
        // Example initialization of bills
        BillModel gasBill = new GasBill( "123456", 50.0f, new Date(), "GasSupplier1", 30.5f);
        gasBill.viewBill();

        BillModel waterBill = new WaterBill( "789012", 75.0f, new Date(), "WaterSupplier1", 45.2f);
        waterBill.viewBill();

        BillModel electricityBill = new ElectricityBill("345678", 100.0f, new Date(), "ElectricitySupplier1", 60.8f);
        electricityBill.viewBill();
    }

}
