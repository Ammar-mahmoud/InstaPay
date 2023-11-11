package Controll;

public class RegistrationBankAccount extends RegistrationService{
    public RegistrationBankAccount(OTPService otpService) {
        super(otpService);
    }

    @Override
    public boolean checkMoneyProvider(String phone) {
        return false;
    }
}
