
package Controll;


import Model.*;
import Controll.TransactionService;
public class BillPaymentService {
    private BillModel bill;
    private UserModel userModel;

    public BillPaymentService(UserModel userModel) {
        this.userModel = userModel;
    }
    public boolean searchBill(String subscriptionNumber, int type) {
        // Search within saved payments of each bill type
        for (BillModel payment : BillModel.getBillDB()) {
            if (payment.getSubscriptionNumber().equals(subscriptionNumber)) {
                this.bill = payment;
                if(checkType(type))return true;
            }
        }
        return false;
    }
    private boolean checkType(int type){
        if(type==1 && bill instanceof GasBill)return true;
        if(type==2 && bill instanceof WaterBill)return true;
        if(type==3 && bill instanceof  ElectricityBill)return true;
        return false;
    }
    public boolean confirmPayment() {
        if (bill != null ) {
            float billValue = bill.getBillValue();
            if (userModel.getMoneyProvider().getBalance() >= billValue) {
                userModel.getMoneyProvider().withdraw(billValue);
                this.bill.savePayment();
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
