package Model;

import java.util.Date;
public abstract class BillModel {
    protected String subscriptionNumber;
    protected float billValue;
    protected Date billingDate;

    public BillModel(String subscriptionNumber, float billValue, Date billingDate) {
        this.subscriptionNumber = subscriptionNumber;
        this.billValue = billValue;
        this.billingDate = billingDate;
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



}
