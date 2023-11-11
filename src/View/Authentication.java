package View;

import Controll.AuthenticationService;

import java.util.Scanner;

public class Authentication {
    public void authentictaionView()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        AuthenticationService authenticationService = new AuthenticationService();
        while(!authenticationService.confirmAccount(username, password)){
            System.out.print("Enter username again: ");
            username = scanner.nextLine();
            System.out.print("Enter password again: ");
            password = scanner.nextLine();
        }
    }
}
