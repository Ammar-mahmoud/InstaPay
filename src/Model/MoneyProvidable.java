package Model;

public abstract class MoneyProvidable {
    protected double balance;
    protected String mobileNumber;

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance(){
        return balance;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
}
