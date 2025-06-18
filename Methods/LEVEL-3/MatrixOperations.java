import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); 

        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] - B[i][j];

        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length;
        int r2 = B.length, c2 = B[0].length;

        if (c1 != r2) {
            throw new IllegalArgumentException("Matrix multiplication not possible!");
        }

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows for Matrix A: ");
        int rowsA = sc.nextInt();
        System.out.print("Enter number of columns for Matrix A: ");
        int colsA = sc.nextInt();

        System.out.print("Enter number of rows for Matrix B: ");
        int rowsB = sc.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int colsB = sc.nextInt();

        int[][] A = generateMatrix(rowsA, colsA);
        int[][] B = generateMatrix(rowsB, colsB);

        System.out.println("Matrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("Matrix Addition (A + B):");
            displayMatrix(addMatrices(A, B));

            System.out.println("Matrix Subtraction (A - B):");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("Addition/Subtraction not possible (dimension mismatch).");
        }

        try {
            System.out.println("Matrix Multiplication (A * B):");
            displayMatrix(multiplyMatrices(A, B));
        } catch (IllegalArgumentException e) {
            System.out.println("Multiplication not possible: " + e.getMessage());
        }

        sc.close();
    }
}
