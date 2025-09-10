interface SensitiveData { }

class UserAccount implements SensitiveData {
    String username;
    String password;

    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class EncryptionService {
    public static String encrypt(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    public static void processObject(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Sensitive data detected! Encrypting before saving...");
            if (obj instanceof UserAccount acc) {
                System.out.println("Encrypted Username : " + encrypt(acc.username));
                System.out.println("Encrypted Password : " + encrypt(acc.password));
            }
        } else {
            System.out.println("No encryption required. Saving as plain data...");
        }
    }
}