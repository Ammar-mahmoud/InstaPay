package Controll;

public class RegistrationWallet extends RegistrationService{
    @Override
    public boolean checkMoneyProvider(String phone) {
        WalletAPI w1=new WalletAPI();
        return w1.checkMoneyProvider();
    }
}
