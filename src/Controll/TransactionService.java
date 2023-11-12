package Controll;
import Model.TransactionModel;
import Model.UserModel;

public abstract class TransactionService {
    protected TransactionModel transactionModel;

    public TransactionService(TransactionModel transactionModel) {
        this.transactionModel = transactionModel;
    }

    public int confirmTransaction(){//return 0 if confirmed else return error type
        if (moneyValidation() )
        {
            if (validToTransfer()){
                if (validDestination()){
                    withdrowSource();
                    transactionModel.saveTransaction();
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        return 3;
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

    public abstract boolean validToTransfer();

    public abstract boolean validDestination();
}
