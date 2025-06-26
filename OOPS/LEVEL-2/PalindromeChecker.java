public class PalindromeChecker {
    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(cleaned).reverse();
        return cleaned.equals(reversed.toString());
    }

    public void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: The text is a palindrome.");
        } else {
            System.out.println("Result: The text is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("Madam");
        checker.displayResult();
    }
}
