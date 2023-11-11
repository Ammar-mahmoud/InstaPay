package Controll;
import Model.BankAccountModel;
public class RegistrationBankAccount extends RegistrationService{
    BankAPI bankAPI;
    public RegistrationBankAccount() {
        bankAPI=new BankAPI();
    }

    @Override
    public boolean checkMoneyProvider(String phone) {
        return bankAPI.checkMoneyProvider();
    }
    public BankAccountModel getAccount(String username){
        return bankAPI.checkBankExiestance(username);
    }
}
