package Controll;

import Model.BillModel;
import Model.GasBill;
import Model.WaterBill;
import Model.ElectricityBill;
public class BillPaymentService {
    private BillModel bill;

    //    private static BillModel[] billDatabase = {
//            new GasBill("123456", 50.0f, new Date(), "GasSupplier1", 30.5f),
//            new WaterBill("789012", 75.0f, new Date(), "WaterSupplier1", 45.2f),
//            new ElectricityBill("345678", 100.0f, new Date(), "ElectricitySupplier1", 60.8f)
//    };
//    public boolean searchBill(String subscriptionNumber) {
//        for (BillModel storedBill : billDatabase) {
//            if (storedBill.getSubscriptionNumber().equals(subscriptionNumber)) {
//                bill = storedBill;
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean searchBill(String subscriptionNumber) {
        // Search within saved payments of each bill type
        for (BillModel payment : GasBill.getSavedPayments()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        for (BillModel payment : WaterBill.getSavedPayments()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        for (BillModel payment : ElectricityBill.getSavedPayments()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        return false;
    }
    public boolean confirmPayment() {
        if (bill != null) {
            bill.savePayment();
            return true;
        } else {
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
