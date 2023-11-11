package Controll;
import Model.WalletModel;
public class WalletAPI {
    public WalletModel checkWalletExiestance(String username){
        for (WalletModel user : WalletModel.wallets) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        System.out.println("The wallet with '" + username + "' Username is not Exists");
        return null;

    }
    public boolean checkMoneyProvider(){
        // assume there is an implementation that tells you about the wallet that has this account and if account valid or not
        return true;
    }

}
