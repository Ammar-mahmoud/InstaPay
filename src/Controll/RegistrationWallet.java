package Controll;

public class RegistrationWallet extends RegistrationService{
    public RegistrationWallet(OTPService otpService) {
        super(otpService);
    }

    @Override
    public boolean checkMoneyProvider(String phone) {
        return false;
    }
}
