package Controll;

public class RegistrationFactory {
    public static final int WALLET_ACCOUNT=1;
    public static final int BANK_ACCOUNT=2;
    public static RegistrationService createRegistration(int ch){
        switch (ch){
            case WALLET_ACCOUNT -> {
                return new RegistrationWallet();
            }
            case BANK_ACCOUNT -> {
                return new RegistrationBankAccount();
            }
            default -> {
                return null;
            }
        }
    }
}
