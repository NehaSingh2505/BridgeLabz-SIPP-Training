import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        final int EMPLOYEE_COUNT = 10;
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.print("Years of Service: ");
            double years = sc.nextDouble();

            if (salary < 0 || years < 0) {
                System.out.println("enter valid salry and years of services : ");
                i--; 
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double bonus;
            if (yearsOfService[i] > 5) {
                bonus = 0.05 * salaries[i];
            } else {
                bonus = 0.02 * salaries[i];
            }
            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;

            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nEmployee\tOld Salary\tBonus\t\tNew Salary");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n", (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }

        System.out.printf("\nTotal Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
}