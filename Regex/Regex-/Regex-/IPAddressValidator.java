import java.util.Scanner;

public class IPAddressValidator {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP address : ");
        String ip = sc.nextLine();

        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        if (ip.matches(regex)) {
            System.out.println("\"" + ip + "\" → Valid IPv4 address");
        } else {
            System.out.println("\"" + ip + "\" → Invalid IPv4 address");
        }
    }
}