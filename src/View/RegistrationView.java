package View;
import Controll.RegistrationFactory;
import Controll.RegistrationService;
import java.util.Scanner;
import Model.UserModel;
public class RegistrationView {
    private RegistrationService registrationService;
    public void registrationView() {
        System.out.println("Enter The Registration Type : ");
        System.out.println("1. By Wallet");
        System.out.println("2. By Bank Account");
        Scanner scanner = new Scanner(System.in);
        int ch = scanner.nextInt();
        while (!(ch == 1 || ch == 2)) {
            System.out.println("Invalid choice. Please choose 1 for Registration By Wallet  or 2 for Registration By Bank Account.");
            ch = scanner.nextInt();
        }
        RegistrationService registrationService = RegistrationFactory.createRegistration(ch);
        scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        while (!registrationService.validUsername(username)) {
            System.out.print("Enter different username: ");
            username = scanner.nextLine();
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        while (!registrationService.validPassword(password)) {
            System.out.print("Enter different password: ");
            password = scanner.nextLine();
        }

        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine();
        while (!registrationService.sendOTP(mobileNumber)) {
            System.out.print("Enter different mobile number: ");
            mobileNumber = scanner.nextLine();
        }


        boolean isValidRegistration = registrationService.validRegistration(username, password, mobileNumber);

        if (isValidRegistration) {
            UserModel newUser = new UserModel(username, password, mobileNumber, registrationService.getAccount(username));
            UserModel.userVector.add(newUser);
            System.out.println("Registration successful!");


        } else {
            System.out.println("Registration failed. Please check your information and try again.");
        }
    }
}
