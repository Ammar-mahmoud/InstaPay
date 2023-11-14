package View;

import Controll.BillPaymentService;
import java.util.Scanner;
import Model.BillModel;
import Model.GasBill;
import Model.WaterBill;
import Model.ElectricityBill;
import Model.UserModel;

public class BillPaymentView {
    private BillPaymentService billPaymentService;
    private UserModel userModel;

    public BillPaymentView(UserModel userModel) {
        this.userModel = userModel;
        this.billPaymentService = new BillPaymentService(userModel);
    }
    public BillPaymentView(BillPaymentService billPaymentService) {
        this.billPaymentService = billPaymentService;
    }
    public BillPaymentService getBillPaymentService() {
        return billPaymentService;
    }
    public void paymentView() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter bill type: ");
            System.out.println("1.Gas Bill. ");
            System.out.println("2.Water Bill. ");
            System.out.println("3.Electricity Bill. ");
            int type=scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter subscription number to search for the bill: ");
            String subscriptionNumber = scanner.nextLine();

            boolean billFound = billPaymentService.searchBill(subscriptionNumber,type);

            if (billFound) {
                System.out.println("Bill found! Displaying details...");

                displayBillDetails(billPaymentService.getBill());

                System.out.println("Do you want to confirm payment? (yes/no)");

                String confirmationInput = scanner.nextLine().toLowerCase();

                if (confirmationInput.equals("yes")) {
                    boolean paymentConfirmed = billPaymentService.confirmPayment();

                    if (paymentConfirmed) {
                        System.out.println("Payment confirmed for Subscription Number: " + subscriptionNumber);
                        System.out.println("Payment has been saved successfully.");
                    } else {
                        System.out.println("Payment confirmation failed. Please try again.");
                        System.out.println("Insufficient balance. Payment confirmation failed.");
                    }
                } else {
                    System.out.println("Payment canceled.");
                }
            } else {
                System.out.println("Bill not found for the provided subscription number.");
            }

            System.out.println("Do you want to perform another Pay Bills operation? (yes/no)");

            String anotherOperationInput = scanner.nextLine().toLowerCase();

            if (!anotherOperationInput.equals("yes")) {
                break;
            }
        }

    }

    // display bill details
    private void displayBillDetails(BillModel bill) {
        if (bill instanceof WaterBill) {
            WaterBill waterBill = (WaterBill) bill;
            System.out.println("Water Bill Details:");
            System.out.println("Subscription Number: " + waterBill.getSubscriptionNumber());
            System.out.println("Bill Value: " + waterBill.getBillValue());
            System.out.println("Billing Date: " + waterBill.getBillingDate());
            System.out.println("Water Supplier: " + waterBill.getWaterSupplier());
            System.out.println("Water Meter Usage: " + waterBill.getWaterMeterUsage());
        } else if (bill instanceof GasBill) {
            GasBill gasBill = (GasBill) bill;
            System.out.println("Gas Bill Details:");
            System.out.println("Subscription Number: " + gasBill.getSubscriptionNumber());
            System.out.println("Bill Value: " + gasBill.getBillValue());
            System.out.println("Billing Date: " + gasBill.getBillingDate());
            System.out.println("Gas Supplier: " + gasBill.getGasSupplier());
            System.out.println("Gas Meter Usage: " + gasBill.getGasMeterUsage());
        } else if (bill instanceof ElectricityBill) {
            ElectricityBill electricityBill = (ElectricityBill) bill;
            System.out.println("Electricity Bill Details:");
            System.out.println("Subscription Number: " + electricityBill.getSubscriptionNumber());
            System.out.println("Bill Value: " + electricityBill.getBillValue());
            System.out.println("Billing Date: " + electricityBill.getBillingDate());
            System.out.println("Electricity Supplier: " + electricityBill.getElectricitySupplier());
            System.out.println("Electricity Meter Usage: " + electricityBill.getElectricityMeterUsage());
        }
    }

}
