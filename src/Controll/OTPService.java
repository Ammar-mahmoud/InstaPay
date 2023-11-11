package Controll;

import java.util.Date;
import java.util.Random;

public class OTPService {

    private Date timer;
    private int OTPLength;

    // Constructor with a 30-second timer
    public OTPService(int OTPLength) {
        this.OTPLength = OTPLength;
        this.timer = new Date(System.currentTimeMillis() + (30 * 1000)); // Set timer to 30 seconds
    }

    public String generateRandomOTP() {
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder();

        for (int i = 0; i < OTPLength; i++) {
            int digit = random.nextInt(10);
            otpBuilder.append(digit);
        }
        //System.out.println(otpBuilder);
        return otpBuilder.toString();
    }

    public boolean send(String mobileNumber , String otp) {
        if (timer.before(new Date())) {
            System.out.println("Time limit exceeded. Please request a new OTP.");
            return false;
        }
        System.out.println("OTP Sent to " + mobileNumber + ": " + otp);
        return true;
    }

    public boolean verifyOTP(String enteredOTP, String generatedOTP) {
        //System.out.println(enteredOTP +" " +generatedOTP);
        if (enteredOTP.trim().length() == generatedOTP.trim().length()) {
            for (int i = 0; i < OTPLength; i++) {
                if (enteredOTP.charAt(i) != generatedOTP.charAt(i)) {
                    return false;
                }
            }
        }
        else return false;
        return true;
    }
}

