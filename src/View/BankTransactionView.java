package View;
import java.util.Date;

import Controll.BankTransaction;
import Controll.TransactionService;
import Model.TransactionModel;
import Model.UserModel;

import java.util.Scanner;

public class BankTransactionView extends TransactionViewable{
    public BankTransactionView(UserModel userModel) {
        super(userModel);
    }

    @Override
    public void transactionView() {
        System.out.println("-- Welcome in Bank Transaction --");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter Bank Account destination: ");
        String distination = scanner.nextLine();
        System.out.print("Enter Value: ");
        double amount = scanner.nextDouble();
        TransactionModel transactionModel = new TransactionModel(
                TransactionModel.transactionVector.size()+1, new Date(),
                userModel.getMobileNumber(), distination, amount);
        transactionService = new BankTransaction(transactionModel);
        int confirm = transactionService.confirmTransaction();
        if (confirm == 0){
            System.out.println("Transfer Done!");
        } else {
            errorHandeling(confirm);
        }
    }
}

