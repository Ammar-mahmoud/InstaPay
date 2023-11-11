package Controll;

import Model.UserModel;

public class AuthenticationService {
    public boolean confirmAccount(String username, String password){
        for (UserModel user : UserModel.userVector) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
