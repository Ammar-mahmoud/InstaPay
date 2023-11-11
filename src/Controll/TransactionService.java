package Controll;
import Model.TransactionModel;
import Model.UserModel;

public abstract class TransactionService {
    protected TransactionModel transactionModel;

    public boolean confirmTransaction(){
        if (moneyValidation())
        {
            if (validDestination()){
                withdrowSource();

                transactionModel.saveTransaction();
                return true;
            }
        }
        return false;
    }

    private boolean moneyValidation(){
        for (UserModel user : UserModel.userVector)
        {
            if (user.getMobileNumber().equals(transactionModel.getSource()))
            {
                if (transactionModel.getTransferValue() <= user.getMoneyProvider().getBalance()){
                    return true;
                }
            }
        }
        return false;
    }

    private void withdrowSource(){
        for (UserModel user : UserModel.userVector)
        {
            if (user.getMobileNumber().equals(transactionModel.getSource()))
            {
                user.getMoneyProvider().withdraw(transactionModel.getTransferValue());
            }
        }
    }
    public abstract void depositDest();

    public abstract boolean validDestination();
}
