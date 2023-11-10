package Model;

public class BankWallet extends WalletModel{
    private String bankName;
    private float moneyLimit;

    public BankWallet(String mobileNumber, float balance, String username, boolean activeStatus, String bankName, float moneyLimit) {
        super(mobileNumber, balance, username, activeStatus);
        this.bankName = bankName;
        this.moneyLimit = moneyLimit;
    }

    @Override
    public void deposit(float amount) {
        // Implement deposit logic for BankWallet
         balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        // Implement withdraw logic for BankWallet
        balance -= amount;
    }

    @Override
    public boolean checkBalance() {
        // Implement checkBalance logic for BankWallet
        return balance > 0;

    }
}
