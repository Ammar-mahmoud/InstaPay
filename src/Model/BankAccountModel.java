package Model;

import java.util.Vector;

public class BankAccountModel extends MoneyProvidable{
    private String accountNumber;
    private String accountHolder;

    public BankAccountModel(String accountNumber, String accountHolder,String phoneNumber , double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.mobileNumber = phoneNumber;
    }


    @Override
    public void deposit(double amount) {
        {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
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
        BankAccountModel account1 = new BankAccountModel("123456789", "user1", "1234567890", 1000.0);
        bankAccountVector.add(account1);

        BankAccountModel account2 = new BankAccountModel("987654321", "roaa","01226692044", 500.0);
        bankAccountVector.add(account2);

        BankAccountModel account3 = new BankAccountModel("111222333", "Yahia Abdallah", "01244556680", 1500.0);
        bankAccountVector.add(account3);

        BankAccountModel account4 = new BankAccountModel("987654322", "ammar mahmoud","01554462054" , 500.0);
        bankAccountVector.add(account2);

        BankAccountModel account5 = new BankAccountModel("246810246", "mohamed wael", "01123559845", 1500.0);
        bankAccountVector.add(account3);
    }


    public String getUsername() {
        return accountHolder;
    }
}
