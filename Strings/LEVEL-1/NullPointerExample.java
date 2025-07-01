public class NullPointerExample {
    static void generateException() {
        String str = null;
        System.out.println(str.length());
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }
}