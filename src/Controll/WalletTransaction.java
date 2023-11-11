package Controll;

import Model.BankAccountModel;
import Model.UserModel;
import Model.WalletModel;

public class WalletTransaction extends TransactionService{
    @Override
    public void depositDest() {
        for (UserModel user : UserModel.userVector)
        {
            if (user.getMobileNumber().equals(transactionModel.getDestination()))
            {
                user.getMoneyProvider().deposit(transactionModel.getTransferValue());
            }
        }
    }

    @Override
    public boolean validDestination() {
        for (WalletModel wallet : WalletModel.wallets){
            if (wallet.getMobileNumber().equals(transactionModel.getDestination())){
                return true;
            }
        }
        return false;
    }
}
