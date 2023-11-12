package Controll;

import Model.UserModel;
import View.UserProfile;

public class AuthenticationService {
    public boolean confirmAccount(String username, String password){
        for (UserModel user : UserModel.userVector) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                UserProfile userProfile = new UserProfile(user);
                userProfile.run();
                return true;
            }
        }
        return false;
    }
}
