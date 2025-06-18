
public class BonusCalculator {

    public static double[][] generateEmployeeData(int employeeCount) {
        double[][] data = new double[employeeCount][2]; 

        for (int i = 0; i < employeeCount; i++) {
            int salary = (int) (Math.random() * 90000) + 10000; 
            int years = (int) (Math.random() * 11); 
            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    public static double[][] calculateBonuses(double[][] oldData) {
        double[][] updatedData = new double[oldData.length][4]; 

        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            int years = (int) oldData[i][1];
            double bonusRate = years > 5 ? 0.05 : 0.02;
            double bonus = oldSalary * bonusRate;
            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary;
            updatedData[i][1] = years;
            updatedData[i][2] = bonus;
            updatedData[i][3] = newSalary;
        }

        return updatedData;
    }

    public static void printReport(double[][] data) {
        double totalOldSalary = 0, totalBonus = 0, totalNewSalary = 0;

        System.out.printf("%-10s %-15s %-15s %-15s\n", "Emp ID", "Old Salary", "Years of Service", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            int empId = i + 1;
            double oldSalary = data[i][0];
            int years = (int) data[i][1];
            double bonus = data[i][2];
            double newSalary = data[i][3];

            System.out.printf("Emp%-7d %-15.2f %-15d %-15.2f %-15.2f\n", empId, oldSalary, years, bonus, newSalary);

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("TOTAL     %-15.2f %-15s %-15.2f %-15.2f\n", totalOldSalary, "-", totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        int employeeCount = 10;
        double[][] employeeData = generateEmployeeData(employeeCount);
        double[][] updatedData = calculateBonuses(employeeData);

        printReport(updatedData);
    }
}
