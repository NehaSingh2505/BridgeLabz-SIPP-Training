public class MultipleCatchDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int index = 5;

        try {
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
