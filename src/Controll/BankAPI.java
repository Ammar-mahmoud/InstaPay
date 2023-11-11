package Controll;
import Model.BankAccountModel;

public class BankAPI {
        public BankAccountModel checkBankExiestance(String username){
            for (BankAccountModel user : BankAccountModel.bankAccountVector) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            System.out.println("This Bank Account is not Exist");
            return null;
        }
        public boolean checkMoneyProvider(){
            // assume there is an implementation that tells you about the bank that has this account and if account valid or not
            return true;
        }
}
