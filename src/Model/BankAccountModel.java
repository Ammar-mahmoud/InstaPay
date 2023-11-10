package Model;

import java.util.Vector;

public class BankAccountModel {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccountModel(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public static Vector<BankAccountModel> bankAccountVector = new Vector<>();

    static {
        BankAccountModel account1 = new BankAccountModel("123456789", "John Doe", 1000.0);
        bankAccountVector.add(account1);

        BankAccountModel account2 = new BankAccountModel("987654321", "Jane Doe", 500.0);
        bankAccountVector.add(account2);

        BankAccountModel account3 = new BankAccountModel("111222333", "Bob Smith", 1500.0);
        bankAccountVector.add(account3);
    }



}
