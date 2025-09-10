import java.util.Scanner;

public class DataSerialization {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Product Code : ");
        String code = sc.nextLine();
        System.out.print("Enter Product Price : ");
        double price = sc.nextDouble();

        Employee emp = new Employee(name, id);
        Product prod = new Product(code, price);

        BackupProcessor.backup(emp);
        BackupProcessor.backup(prod);
	}
}
