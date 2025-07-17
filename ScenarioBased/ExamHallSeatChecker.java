import java.util.Arrays;

public class ExamHallSeatChecker {
    public static void main(String[] args) {
        int examHalls [][]= {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };
        seatCheck(examHalls, 15);
    }

    public static void seatCheck(int examHalls[][], int seat) {
        for (int i = 0; i < examHalls.length; i++) {
            int position = Arrays.binarySearch(examHalls[i], seat);
            if (position >= 0) {
                System.out.println("Seat found in Hall " + (i + 1) + " at position " + position);
                return;
            }
        }
        System.out.println("Seat not found");
    }
}