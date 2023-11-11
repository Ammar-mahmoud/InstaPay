package View;

import Controll.OTPService;
import Controll.RegistrationBankAccount;
import Controll.RegistrationService;
import Controll.RegistrationWallet;

import java.util.Scanner;

public class WelcomeView {
    public void enterview() {
        System.out.println("Welcome to InstaPay System!");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();


        while (!(choice == 1 || choice == 2)) {
            System.out.println("Invalid choice. Please choose 1 for Sign Up or 2 for Sign In.");
            choice=scanner.nextInt();
        }

        if (choice == 1) {
            System.out.println("Enter The Registration Type : ");
            System.out.println("1. By Wallet");
            System.out.println("2. By Bank Account");
            int ch=scanner.nextInt();
            while (!(ch== 1 || ch == 2)) {
                System.out.println("Invalid choice. Please choose 1 for Registration By Wallet  or 2 for Registration By Bank Account.");
                ch=scanner.nextInt();
            }
            if(ch==1) {
                // factory design pattern
                RegistrationView registrationView = new RegistrationView(new RegistrationWallet(new OTPService(6)));
                registrationView.registrationView();
            }
            else{
                RegistrationView registrationView = new RegistrationView(new RegistrationBankAccount(new OTPService(6)));
                registrationView.registrationView();
            }
        } else if (choice == 2) {
            // Call the authentication view or method
        }
    }

    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.enterview();
    }
}
