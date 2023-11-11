package View;
import Controll.RegistrationService;
import java.util.Scanner;
import Model.UserModel;
public class RegistrationView {
    private RegistrationService registrationService;

    public RegistrationView(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void registrationView() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Registration successful!");

        } else {
            System.out.println("Registration failed. Please check your information and try again.");
        }
    }
}
