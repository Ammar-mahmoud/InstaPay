package View;

import Controll.TransactionService;
import Controll.WalletTransaction;
import Model.TransactionModel;
import Model.UserModel;

import java.util.Scanner;

public class WalletTransactionView extends TransactionViewable{

    public WalletTransactionView(UserModel userModel) {
        super(userModel);
    }

    @Override
    public void transactionView() {
        System.out.println("-- welcome in Wallet transaction --");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter Destination Mobile Number: ");
        String mobileNumber = scanner.nextLine();
        System.out.print("Enter the amount of money: ");
        double money = scanner.nextDouble();
        TransactionModel transactionModel = new TransactionModel(
                TransactionModel.transactionVector.size()+1, new Date(),
                userModel.getMobileNumber(), mobileNumber, money);
        transactionService = new WalletTransaction(transactionModel);
        int confirm = transactionService.confirmTransaction();
        if (confirm == 0){
            System.out.println("Transfer Done!");
        } else{
            errorHandeling(confirm);
        }

    }
}
