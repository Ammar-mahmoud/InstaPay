package Controll;

import Model.WalletModel;

public class RegistrationWallet extends RegistrationService{
    WalletAPI walletAPI;
    public RegistrationWallet() {
        walletAPI=new WalletAPI();
    }

    @Override
    public boolean checkMoneyProvider(String phone) {
        return walletAPI.checkMoneyProvider();
    }

    @Override
    public WalletModel getAccount(String username) {
        return walletAPI.checkWalletExiestance(username);
    }
}
