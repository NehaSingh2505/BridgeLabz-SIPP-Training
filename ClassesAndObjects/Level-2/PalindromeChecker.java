class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--)
            reversed += text.charAt(i);
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        System.out.println("Text: " + text);
        if (isPalindrome())
            System.out.println("It is a Palindrome.");
        else
            System.out.println("It is NOT a Palindrome.");
    }

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker("Madam");
        pc.displayResult();
    }
}
