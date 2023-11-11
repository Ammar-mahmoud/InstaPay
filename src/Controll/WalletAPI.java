package Controll;
import Model.WalletModel;
public class WalletAPI {
    public void createWalletAccount(String username) {
        // Assume some logic to create a wallet account for the given username
        System.out.println("Wallet account created for user: " + username);
    }
    public boolean checkWalletExiestance(String username){
        for (WalletModel user : WalletModel.wallets) {
            if (user.getUsername().equals(username)) {
                System.out.println("The wallet with '" + username + "' Username already exists");
                return false;
            }
        }
        return true;

    }
    public boolean checkMoneyProvider(){
        // assume there is an implementation that tells you about the wallet that has this account and if account valid or not
        return true;
    }

}
