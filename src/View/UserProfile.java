package View;
import Controll.BillPaymentService;
import Controll.WalletTransaction;
import Model.UserModel;

import java.util.Scanner;

public class UserProfile {
    private UserModel userModel;
    public UserProfile(UserModel newUser) {
        this.userModel=newUser;
    }


    public void viewUserProfile() {
        System.out.println("Welcome in Profile for: " + userModel.getUsername()+" With Mobile Number: " + userModel.getMobileNumber());
    }

    public int displayOptions() {
        System.out.println("Choose The Operation Number That You Want :");
        System.out.println("1. Transfer to Wallet using the mobile number");
        System.out.println("2. Transfer to Another instapay account");
        System.out.println("3. Inquire about his balance");
        System.out.println("4. Pay bills");
        System.out.println("5. Exit");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
    public void run(){
        viewUserProfile();
        while (true){
            int ch=displayOptions();
            if(ch == 1){
                WalletTransactionView walletTransactionView = new WalletTransactionView(userModel);
                walletTransactionView.transactionView();
            } else if (ch==2) {
                BankTransactionView bankTransactionView = new BankTransactionView(userModel);
                bankTransactionView.transactionView();
            }
            else if(ch==3){
                System.out.println("Your balance: " + userModel.getMoneyProvider().getBalance() + '$');
            }
            else if(ch ==4){
                BillPaymentView billPaymentView=new BillPaymentView(new BillPaymentService());
                billPaymentView.paymentView();
            }
            else{
                System.exit(0);
            }

        }
    }
}
