package Controll;
import Model.MoneyProvidable;
import Model.UserModel;
import java.util.Scanner;

public abstract class RegistrationService {
        public  boolean validRegistration(String username, String password, String mobileNumber){
            return validUsername(username) && validPassword(password);
        }

        public  boolean validUsername(String username){
                for (UserModel user : UserModel.userVector) {
                        if (user.getUsername().equals(username)) {
                                System.out.println("Username '" + username + "' already exists. Please choose a different username.");
                                return false;
                        }
                }
                return true;
        }

        public boolean validPassword(String password){
                if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8}$")){
                        return true;
                }
                else{
                        System.out.println("Please Create A strong Password that follows this Rules: ");
                        System.out.println("1-Your Password must have exactly 8 characters ");
                        System.out.println("2-Your Password must have at least 1 UpperCase & 1 lowerCase");
                        System.out.println("3-Yout Password must have at least 1 number ");
                        System.out.println("3-Yout Password must have at least 1 Symbol ");

                        return false;
                }
        }

        public boolean sendOTP(String phone) {
                OTPService otpService=new OTPService(6);
                String generatedOTP = otpService.generateRandomOTP();
                while(!otpService.send(phone, generatedOTP)) {
                        ;
                }

                Scanner scanner = new Scanner(System.in);

                while (true) {
                        System.out.print("Enter OTP: ");
                        String enteredOTP = scanner.nextLine().trim();

                        if (otpService.verifyOTP(enteredOTP, generatedOTP)) {
                                System.out.println("OTP verification successful!");
                                break;
                        } else {
                                System.out.print("Invalid OTP. Enter a different OTP: ");
                        }
                }
                return true;
        }

        public abstract boolean checkMoneyProvider(String phone);
        public abstract MoneyProvidable getAccount(String username);

}
