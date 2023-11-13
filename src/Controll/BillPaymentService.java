
package Controll;


import Model.*;
import Controll.TransactionService;
public class BillPaymentService {
    private BillModel bill;
    private UserModel userModel;

    public BillPaymentService(UserModel userModel) {
        this.userModel = userModel;
    }
    public boolean searchBill(String subscriptionNumber) {
        // Search within saved payments of each bill type
        for (BillModel payment : GasBill.getGasBillDB()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        for (BillModel payment : WaterBill.getWaterBillDB()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        for (BillModel payment : ElectricityBill.getElectricityBillDB()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                bill = payment;
                return true;
            }
        }

        return false;
    }
    public boolean confirmPayment() {
        if (bill != null ) {
            float billValue = bill.getBillValue();
            if (userModel.getMoneyProvider().getBalance() >= billValue) {
                userModel.getMoneyProvider().withdraw(billValue);
                bill.savePayment();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void setBill(BillModel bill) {
        this.bill = bill;
    }

    public BillModel getBill() {
        return bill;
    }
}
