package Controll;

import Model.BillModel;
import Model.GasBill;
import Model.WaterBill;
import Model.ElectricityBill;
import java.util.Date;
public class BillPaymentService {
    private BillModel bill;
    private static BillModel[] billDatabase = {
            new GasBill("123456", 50.0f, new Date(), "GasSupplier1", 30.5f),
            new WaterBill("789012", 75.0f, new Date(), "WaterSupplier1", 45.2f),
            new ElectricityBill("345678", 100.0f, new Date(), "ElectricitySupplier1", 60.8f)
    };

    public boolean searchBill(String subscriptionNumber) {
        for (BillModel storedBill : billDatabase) {
            if (storedBill.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = storedBill;
                return true;
            }
        }
        return false;
    }
    public boolean confirmPayment() {
        if (bill != null) {
            System.out.println("Payment confirmed for Subscription Number: " + bill.getSubscriptionNumber());
            return true;
        } else {
            System.out.println("No bill to confirm payment. Please search for a bill first.");
            return false;
        }
    }

    public void setBill(BillModel bill) {
        this.bill = bill;
    }

    public BillModel getBill() {
        return bill;
    }
}
