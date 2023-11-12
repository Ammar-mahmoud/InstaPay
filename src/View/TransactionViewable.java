package View;

import Controll.TransactionService;
import Model.UserModel;

import java.util.Scanner;

public abstract class TransactionViewable {
    protected TransactionService transactionService;
    protected UserModel userModel;

    public TransactionViewable(UserModel userModel) {
        this.userModel = userModel;
    }


    public abstract void transactionView();
    public void errorHandeling(int confirm){
        if (confirm == 1){
            System.out.println("Destination is not valid!");
        }
        else if (confirm == 2){
            System.out.println("Destination is not provided to send Money from your Money Provider!");
        }

        else if (confirm == 3) {
            System.out.println("Not enough money");
        }
        System.out.print("click 1 to try again\nany number for return to menu: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1)
            transactionView();
        else
            return;
    }
}
