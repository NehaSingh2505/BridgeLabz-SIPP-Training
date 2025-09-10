import java.util.Scanner;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

// Step 2: Main class
public class PasswordStrengthValidator {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password : ");
        String password = sc.nextLine();

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Strong Password Accepted!");
        } else {
            System.out.println("Weak Password! Must have : ");
            System.out.println("- At least 8 characters");
            System.out.println("- Uppercase & Lowercase letter");
            System.out.println("- At least 1 digit");
            System.out.println("- At least 1 special character");
        }
    }
}
