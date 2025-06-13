public class PcmAverageCalculator {

    public static void main(String[] args) {
        int physicsMarks = 95;
        int chemistryMarks = 96;
        int mathsMarks = 94;

        double averagePercentage = calculateAverage(physicsMarks, chemistryMarks, mathsMarks);
        System.out.println("Sam’s average mark in PCM is " + averagePercentage + "%");
    }

    // Method to calculate average
    public static double calculateAverage(int physics, int chemistry, int maths) {
        int totalMarks = physics + chemistry + maths;
        return totalMarks / 3.0;
    }
}
