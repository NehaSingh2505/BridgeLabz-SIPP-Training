// evel 2 Practice Programs
// Write a program to create a basic calculator for addition, subtraction, multiplication, and division. The program should ask for two numbers (floating point) and perform all the operations
// Hint => 
// Create a variable number1 and number2 and take user inputs.
// Perform Arithmetic Operations of addition, subtraction, multiplication, and division assign the result to a variable, and finally print the result
// I/P => number1, number2
// O/P => The addition, subtraction, multiplication, and division value of 2 numbers ___ and ___ is ___, ____, ____, and ___

import java.util.Scanner;
public class BasicCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        float number1 = sc.nextFloat();
        
        System.out.print("Enter second number: ");
        float number2 = sc.nextFloat();
        
        // Performing arithmetic operations
        float addition = number1 + number2;
        float subtraction = number1 - number2;
        float multiplication = number1 * number2;
        float division = number1 / number2;
        System.out.println("the addition of " + number1 + " and " + number2 + " is : " + addition);
        System.out.println("the subtraction of " + number1 + " and " + number2 + " is :" + subtraction);
        System.out.println("the multiplication of " + number1 + " and " + number2 + " is :" + multiplication);
        System.out.println("the division of " + number1 + " and " + number2 + " is :" + division);
        
        sc.close();

    }
}