package Model;

public abstract class MoneyProvidable {
    protected double balance;
    protected String mobileNumber;

    public abstract void deposit(float amount);
    public abstract void withdraw(float amount);

    public double getBalance(){
        return balance;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
}
