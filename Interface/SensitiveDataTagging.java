import java.util.Scanner;
public class SensitiveDataTagging {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter username : ");
        String uname = sc.nextLine();

        System.out.print("Enter password : ");
        String pwd = sc.nextLine();

        // Create tagged object
        UserAccount user = new UserAccount(uname, pwd);

        // Process with encryption utility
        EncryptionService.processObject(user);
	}
}
