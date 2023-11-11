package View;

import Controll.BillPaymentService;
import java.util.Scanner;

public class BillPaymentView {
    private BillPaymentService billPaymentService;

    public BillPaymentView(BillPaymentService billPaymentService) {
        this.billPaymentService = billPaymentService;
    }
    public BillPaymentService getBillPaymentService() {
        return billPaymentService;
    }
    public void paymentView() {
        System.out.println("Displaying Payment View...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter subscription number to search for the bill: ");
        String subscriptionNumber = scanner.nextLine();

        boolean billFound = billPaymentService.searchBill(subscriptionNumber);

        if (billFound) {
            System.out.println("Bill found! Displaying details...");
            billPaymentService.getBill().viewBill();
            System.out.println("Do you want to confirm payment? (yes/no)");

            String confirmationInput = scanner.nextLine().toLowerCase();

            if (confirmationInput.equals("yes")) {
                boolean paymentConfirmed = billPaymentService.confirmPayment();

                if (paymentConfirmed) {
                    System.out.println("Payment confirmed. Thank you!");
                } else {
                    System.out.println("Payment confirmation failed. Please try again.");
                }
            } else {
                System.out.println("Payment canceled.");
            }
        } else {
            System.out.println("Bill not found for the provided subscription number.");
        }
        scanner.close();
    }

}
