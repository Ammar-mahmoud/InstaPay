package Model;

public class ElectronicWallet extends WalletModel{
    private String qrData;

    public ElectronicWallet(String mobileNumber, float balance, String username, boolean activeStatus, String qrData) {
        super(mobileNumber, balance, username, activeStatus);
        this.qrData = qrData;
    }

    @Override
    public void deposit(float amount) {
        // Implement deposit logic for ElectronicWallet
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        // Implement withdraw logic for ElectronicWallet
        this.balance -= amount;
    }

    @Override
    public boolean checkBalance() {
        // Implement checkBalance logic for ElectronicWallet
        return this.balance > 0;
    }
}
