package Controll;
import Model.BankAccountModel;

public class BankAPI {
        public boolean checkBankExiestance(String username){
            for (BankAccountModel user : BankAccountModel.bankAccountVector) {
                if (user.getUsername().equals(username)) {
                    System.out.println("The wallet with '" + username + "' Username already exists");
                    return false;
                }
            }
            return true;

        }
        public boolean checkMoneyProvider(){
            // assume there is an implementation that tells you about the bank that has this account and if account valid or not
            return true;
        }
}
