package Controll;

public class RegistrationBankAccount extends RegistrationService{
    @Override
    public boolean checkMoneyProvider(String phone) {
        BankAPI B1=new BankAPI();
        return B1.checkMoneyProvider();
    }
}
