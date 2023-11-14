package Controll;
import Model.MoneyProvidable;
import Model.UserModel;
import java.util.Scanner;

public abstract class RegistrationService {
        public  UserModel validRegistration(String username, String password, String mobileNumber){
                if (validUsername(username) && validPassword(password))
                {
                        UserModel newUser = new UserModel(username, password, mobileNumber, getAccount(username));
                        UserModel.userVector.add(newUser);
                        return newUser;
                }
                return null;
        }

        public  boolean validUsername(String username){
                for (UserModel user : UserModel.userVector) {
                        if (user.getUsername().equals(username)) {
                                return false;
                        }
                }
                if(getAccount(username) ==null)
                        return false;
                else return true;
        }

        public boolean validPassword(String password){
                if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d@$!%*?&]{8}$")){
                        return true;
                }
                else{
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
