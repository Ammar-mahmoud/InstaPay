package Model;
import java.util.Vector;

public class UserModel {
    private String username;
    private String password;
    private String mobileNumber;

    private  MoneyProvidable moneyProvider ;

    public UserModel(String username, String password, String mobileNumber, MoneyProvidable moneyProvider) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;

        this.moneyProvider = moneyProvider;

    }
    public void saveUser() {
        // Save the user to the vector
        UserModel.userVector.add(this);
        System.out.println("User saved: " + this.toString());
    }
    public static Vector<UserModel> userVector = new Vector<>();
    static {
        UserModel user1 = new UserModel("user1", "password1", "1234567890", new BankAccountModel("123456789", "user1", 1000.0));
        UserModel user2 = new UserModel("user2", "password2", "9876543210",  new TeleWallet("01020202020", 2000, "user2", true, "Telecom1"));


        userVector.add(user1);
        userVector.add(user2);
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}