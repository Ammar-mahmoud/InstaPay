package Model;

public class TeleWallet extends WalletModel{
    private String telecommunicationCompany;

    public TeleWallet(String mobileNumber, float balance, String username, boolean activeStatus, String telecommunicationCompany) {
        super(mobileNumber, balance, username, activeStatus);
        this.telecommunicationCompany = telecommunicationCompany;
    }

    @Override
    public void deposit(double amount) {
        // Implement deposit logic for TeleWallet
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        // Implement withdraw logic for TeleWallet
        this.balance -= amount;
    }

    @Override
    public boolean checkBalance() {
        // Implement checkBalance logic for TeleWallet
        return this.balance > 0;
    }

    public String getTelecommunicationCompany() {
        return telecommunicationCompany;
    }
}
