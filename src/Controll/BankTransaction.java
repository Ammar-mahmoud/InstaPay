package Controll;

import Model.BankAccountModel;
import Model.TransactionModel;
import Model.UserModel;

public class BankTransaction extends TransactionService{
    public BankTransaction(TransactionModel transactionModel) {
        super(transactionModel);
    }

    @Override
    public void depositDest() {
        for (BankAccountModel account : BankAccountModel.bankAccountVector)
        {
            if (account.getAccountNumber().equals(transactionModel.getDestination()))
            {
                account.deposit(transactionModel.getTransferValue());
            }
        }
    }

    @Override
    public boolean validToTransfer() {
        for (UserModel user : UserModel.userVector)
        {
            if (user.getMobileNumber().equals(transactionModel.getSource()))
            {
                if (user.getMoneyProvider() instanceof BankAccountModel){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean validDestination() {
        for (BankAccountModel account : BankAccountModel.bankAccountVector)
        {
            if (account.getAccountNumber().equals(transactionModel.getDestination()))
            {
                return true;
            }
        }
        return false;
    }
}
