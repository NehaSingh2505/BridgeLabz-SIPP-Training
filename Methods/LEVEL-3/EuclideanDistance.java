import java.util.Scanner;

public class EuclideanDistance {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static double[] getLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        if (x2 == x1) {
            System.out.println("The line is vertical; slope is undefined.");
            result[0] = Double.POSITIVE_INFINITY;
            result[1] = Double.NaN;
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            double intercept = y1 - slope * x1;
            result[0] = slope;
            result[1] = intercept;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coordinates
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Calculate distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance = %.2f\n", distance);

        // Get slope and intercept
        double[] lineEq = getLineEquation(x1, y1, x2, y2);
        if (!Double.isInfinite(lineEq[0])) {
            System.out.printf("Equation of line: y = %.2fx + %.2f\n", lineEq[0], lineEq[1]);
        }

        sc.close();
    }
}
