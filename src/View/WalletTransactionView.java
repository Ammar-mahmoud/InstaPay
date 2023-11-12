package View;

import Controll.TransactionService;
import Model.TransactionModel;

import java.util.Scanner;

public class WalletTransactionView implements TransactionViewable{
    @Override
    public void transactionView() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Destination Mobile Number: ");
        String mobileNumber = scanner.nextLine();
        System.out.print("Enter the amount of money: ");
        float Money = scanner.nextFloat();
        TransactionService transactionService = new TransactionService();

    }
}
