package Controll;

import Model.BankAccountModel;
import Model.UserModel;

public class BankTransaction extends TransactionService{
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
    public boolean validDestination() {
        for (BankAccountModel account : BankAccountModel.bankAccountVector)
        {
            if (account.getMobileNumber().equals(transactionModel.getDestination()))
            {
                return true;
            }
        }
        return false;
    }
}
