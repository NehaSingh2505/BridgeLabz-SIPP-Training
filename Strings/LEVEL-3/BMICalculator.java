import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        double[][] data = getUserInput(10);
        String[][] bmiTable = createBMITable(data);
        displayTable(bmiTable);
    }

    public static double[][] getUserInput(int n) {
        Scanner sc = new Scanner(System.in);
        double[][] input = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            input[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            input[i][1] = sc.nextDouble();
        }
        return input;
    }

    public static String[][] createBMITable(double[][] data) {
        String[][] table = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            bmi = Math.round(bmi * 100.0) / 100.0;

            table[i][0] = String.valueOf(heightCm);
            table[i][1] = String.valueOf(weight);
            table[i][2] = String.valueOf(bmi);
            table[i][3] = getBMIStatus(bmi);
        }
        return table;
    }

    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void displayTable(String[][] table) {
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%s\t\t%s\t\t%s\t\t%s\n",
                table[i][0], table[i][1], table[i][2], table[i][3]);
        }
    }
}
