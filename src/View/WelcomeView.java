package View;

import Controll.*;

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
            RegistrationView registrationView=new RegistrationView();
            registrationView.registrationView();
        } else if (choice == 2) {
            // Call the authentication view or method
        }
    }
    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.enterview();
    }
}
