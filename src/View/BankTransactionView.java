package View;

import Model.TransactionModel;

import java.util.Scanner;

public class BankTransactionView implements TransactionViewable{
    @Override
    public void transactionView() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bank Account destination: ");
        String distination = scanner.nextLine();
        System.out.print("Enter Value: ");
        float amount = scanner.nextFloat();
        TransactionModel transactionModel = new TransactionModel();

    }
}
