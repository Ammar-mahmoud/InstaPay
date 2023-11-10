package Model;
import java.util.Vector;

public class UserModel {
    private String username;
    private String password;
    private String mobileNumber;
    private BankAccountModel bankAccount;
    private WalletModel walletAccount;

    public UserModel(String username, String password, String mobileNumber, BankAccountModel bankAccount, WalletModel walletAccount) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.bankAccount = bankAccount;
        this.walletAccount = walletAccount;
    }

    public void saveUser() {
        // Save the user to the vector
        UserModel.userVector.add(this);
        System.out.println("User saved: " + this.toString());
    }
    public static Vector<UserModel> userVector = new Vector<>();

}